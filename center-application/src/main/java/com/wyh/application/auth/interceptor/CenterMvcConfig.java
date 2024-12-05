package com.wyh.application.auth.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CenterMvcConfig implements WebMvcConfigurer {

    private final TokenInterceptor tokenInterceptor;

    public CenterMvcConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录拦截器
        registry.addInterceptor(this.tokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/static/**","/error","/login").order(0);
    }
}
