package com.smile.hrsys.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 登录验证
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String verify_code = (String) request.getSession().getAttribute("verify_code");
        String contentType = request.getContentType();
        if (contentType.contains(MediaType.APPLICATION_JSON_VALUE)
                || contentType.contains(MediaType.APPLICATION_JSON_UTF8_VALUE)) {
            Map<String, String> loginData = new HashMap<>();

            try {
                loginData = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            } catch (IOException e) {
                //e.printStackTrace();
            } finally {
                String code = loginData.get("code");
                checkCode(response, code, verify_code);
            }

            String username = loginData.get(getUsernameParameter());
            String password = loginData.get(getPasswordParameter());
            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            username = username.trim();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
            setDetails(request, authentication);
            return this.getAuthenticationManager().authenticate(authentication);
        }

        return super.attemptAuthentication(request, response);
    }

    /**
     * 检查验证码
     * @param resp
     * @param code
     * @param verify_code
     */
    public void checkCode(HttpServletResponse resp, String code, String verify_code) {
        System.out.println("------> " + code + " | " + verify_code + "|");
        if (code == null || verify_code == null || "".equals(code)
                || !verify_code.toLowerCase().equals(code.toLowerCase())) {
            throw new AuthenticationServiceException("验证码不正确！");
        }
    }
}
