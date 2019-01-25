package com.venkateshgangisetti.FlagPicker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@Order(1)
public class RequestResponseLoggingFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info(
                "Logging Request  {} : {}", req.getMethod(),
                req.getRequestURI());
        chain.doFilter(request, response);
        logger.info(
                "Logging Response :{}",
                res.getContentType());
    }

//    @Bean
//    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
//        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
//                = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new RequestResponseLoggingFilter());
//        registrationBean.addUrlPatterns("/flags/*");
//
//        return registrationBean;
//    }

}
