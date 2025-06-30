package cn.com.chinahitech.bjmarket.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("用户系统API文档")
                        .version("1.0.0")
                        .description("这是一个演示 Knife4j 4.3.0 的 Spring Boot 项目")
                        .contact(new Contact().name("开发者").email("dev@example.com"))
                );
    }
}
