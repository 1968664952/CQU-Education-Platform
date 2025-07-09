package cn.com.chinahitech.bjmarket.config;


import cn.com.chinahitech.bjmarket.interceptor.JwtRoleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;



@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtRoleInterceptor("admin"))
                .addPathPatterns("/admin/admin")           // 拦截所有 /admin 路径
                .excludePathPatterns("/admin/login");   // 放行登录接口


        // 用户拦截器配置
        registry.addInterceptor(new JwtRoleInterceptor("user"))
                .addPathPatterns(
                        "/wrongCollection/admin"

                )                 // 拦截根路径下的一层路径
                .excludePathPatterns( "/api/login");
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
