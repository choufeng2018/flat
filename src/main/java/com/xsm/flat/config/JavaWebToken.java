package com.xsm.flat.config;

import com.xsm.flat.utils.SystemUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * Created by 薛时鸣 on 2018/1/2.
 *
 * @author 薛时鸣
 * @date 2018/1/2
 */
public class JavaWebToken {

    private static Logger log = LoggerFactory.getLogger(JavaWebToken.class);

    private final static String SECRET_KEY = "base64EncodedSecretKey";

    //该方法使用HS256算法和Secret:bankgl生成signKey
    private static Key getKeyInstance() {
        //We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("bankgl");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    /*自动生成的key*/
    private static Key getGenerateKey() {
        return MacProvider.generateKey();
    }

    //使用HS256签名算法和生成的signingKey最终的Token,claims中是有效载荷
    public static String createJavaWebToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
    }

    //使用HS256签名算法和生成的signingKey最终的Token,claims中是有效载荷
    /*
    JWT标准里面定好的claim有：
    iss(Issuser)：代表这个JWT的签发主体；
    sub(Subject)：代表这个JWT的主体，即它的所有人；
    aud(Audience)：代表这个JWT的接收对象；
    exp(Expiration time)：是一个时间戳，代表这个JWT的过期时间；
    nbf(Not Before)：是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的；
    iat(Issued at)：是一个时间戳，代表这个JWT的签发时间；
    jti(JWT ID)：是JWT的唯一标识。
    */
    public  String createJavaWebToken(String subject) {
        /*return Jwts.builder().setSubject(subject).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();*/
        Date startDate = new Date();
        Date expiryDate = SystemUtil.addDate(startDate,30);//设置期限30天后过期
        return Jwts.builder()
                .setSubject(subject)//拥有者
                .setIssuedAt(startDate)//签发时间
                .setExpiration(expiryDate)//过期时间
                .signWith(SignatureAlgorithm.HS256,getKeyInstance())//使用密钥加密
                .compact();//协议生成
    }


    /*
    payload的claim验证，拿前面标准的claim来一一说明：

iss(Issuser)：如果签发的时候这个claim的值是“a.com”，验证的时候如果这个claim的值不是“a.com”就属于验证失败；
sub(Subject)：如果签发的时候这个claim的值是“liuyunzhuge”，验证的时候如果这个claim的值不是“liuyunzhuge”就属于验证失败；
aud(Audience)：如果签发的时候这个claim的值是“['b.com','c.com']”，验证的时候这个claim的值至少要包含b.com，c.com的其中一个才能验证通过；
exp(Expiration time)：如果验证的时候超过了这个claim指定的时间，就属于验证失败；
nbf(Not Before)：如果验证的时候小于这个claim指定的时间，就属于验证失败；
iat(Issued at)：它可以用来做一些maxAge之类的验证，假如验证时间与这个claim指定的时间相差的时间大于通过maxAge指定的一个值，就属于验证失败；
jti(JWT ID)：如果签发的时候这个claim的值是“1”，验证的时候如果这个claim的值不是“1”就属于验证失败
    */
    //解析Token，同时也能验证Token，当验证失败返回null
    public static Claims parserJavaWebToken(String jwt) {
        try {
            //解析成功后返回
            return Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
        } catch (Exception e) {//SignatureException e
            log.error("json web token verify failed");
            return null;
        }
    }
}
