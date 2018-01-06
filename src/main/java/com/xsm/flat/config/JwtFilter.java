package com.xsm.flat.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		//这里填写你允许进行跨域的主机ip
	//	response.setHeader("Access-Control-Allow-Origin", "*");
		//允许跨域携带cookies
	//	response.setHeader("Access-Control-Allow-Credentials","true");
		//允许的访问方法
	//	response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
		//Access-Control-Max-Age 用于 CORS 相关配置的缓存
	//	response.setHeader("Access-Control-Max-Age", "3600");
	//	response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

		String authHeader = request.getHeader("Authorization");
		System.out.println(request.getRequestURI());
		if("/login".equals(request.getRequestURI())
				||"/pc-geetest/register".equals(request.getRequestURI())
				||"/pc-geetest/validate".equals(request.getRequestURI())){
			chain.doFilter(req, res);
		}else
		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(req, res);
		} else {
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				System.out.println(authHeader);
				throw new ServletException("不合法的Authorization header");
			}
			// 取得token
			String token = authHeader.substring(7);
			//解密token
			Claims claims = JavaWebToken.parserJavaWebToken(token);
			if(claims==null){
				throw new ServletException("Invalid Token");
			}
			request.setAttribute("claims", claims);
			/*
			try {
				Claims claims = Jwts.parser().setSigningKey("base64EncodedSecretKey").parseClaimsJws(token).getBody();
				request.setAttribute("claims", claims);
			} catch (Exception e) {
				throw new ServletException("Invalid Token");
			}*/
			chain.doFilter(req, res);
		}
	}

}
