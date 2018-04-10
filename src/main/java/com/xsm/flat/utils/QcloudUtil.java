package com.xsm.flat.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.net.URL;
import java.util.Date;

/**
 * Created by 薛时鸣 on 18-4-7.
 *
 * @author 薛时鸣
 * @date 18-4-7
 */
public class QcloudUtil {
    public static final String APP_ID = "1253646934";
    public static final String SECRET_ID = "AKID6HJBP0cDf2FH8ZQJlLo6D9IOteHjhHsL";
    public static final String SECRET_KEY = "SsKlBcu0ucIrK1nbLIMNEwTyZSRTvobD";
    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    public static final String Bucket_NAME = "aijia-flat-sh-1253646934";
    public static final String Region_NAME = "ap-shanghai";

    public static COSClient getCOSClient(){
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(Region_NAME));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        return cosclient;
    }

    public static URL getUploadUrl(String key){
        COSClient cosclient = getCOSClient();
        // 指定要上传到 COS 上的路径
        //String key = "/upload_single_demo.txt";
        // 设置签名过期时间(可选), 若未进行设置, 则默认使用ClientConfig中的签名过期时间(5分钟)
        // 这里设置签名在半个小时后过期
        Date expirationTime = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        URL url = cosclient.generatePresignedUrl(Bucket_NAME, key, expirationTime, HttpMethodName.PUT);
        return url;
    }

    public static PutObjectResult uploadFileToCos(String key,File file){
        COSClient cosClient = getCOSClient();
        PutObjectRequest putObjectRequest = new PutObjectRequest(Bucket_NAME, key, file);
        // 本地文件上传
//        Upload upload = transferManager.upload(putObjectRequest);
//        // 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
//        UploadResult uploadResult = upload.waitForUploadResult();
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        return putObjectResult;
    }

    public static String getQcloudFileUrl(String fileName){
        return "http://"+Bucket_NAME+".cossh.myqcloud.com/"+fileName;
    }
}
