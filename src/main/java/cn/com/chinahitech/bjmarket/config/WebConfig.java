package cn.com.chinahitech.bjmarket.config;


import cn.com.chinahitech.bjmarket.interceptor.JwtRoleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;



@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtRoleInterceptor("admin"))
                .addPathPatterns("/admin/admin");

        registry.addInterceptor(new JwtRoleInterceptor("user"))
                .addPathPatterns("/user/admin");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 生产环境应限制来源
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}
