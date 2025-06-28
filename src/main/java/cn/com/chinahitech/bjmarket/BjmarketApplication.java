package cn.com.chinahitech.bjmarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("cn.com.chinahitech.bjmarket.*.mapper")
@MapperScan("cn.com.chinahitech.bjmarket.login.Mapper")
public class BjmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BjmarketApplication.class, args);
    }

}