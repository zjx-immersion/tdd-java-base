package com.tw.config;

import com.tw.config.properties.CORSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by jxzhong on 2017/7/3.
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(CORSProperties.class)
public class CORSFilter implements Filter {

    @Autowired
    private CORSProperties corsProperties;

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Origin",
                String.join(",", corsProperties.getAllowedOrigins()));
        response.setHeader("Access-Control-Allow-Methods",
                String.join(",", corsProperties.getAllowedMethods()));
        response.setHeader("Access-Control-Max-Age",
                corsProperties.getMaxAge().toString());
        response.setHeader("Access-Control-Allow-Headers",
                String.join(",", corsProperties.getAllowedHeaders()));
        response.setHeader("Access-Control-Allow-Credentials",
                corsProperties.isAllowCredentials().toString());

        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }

}

