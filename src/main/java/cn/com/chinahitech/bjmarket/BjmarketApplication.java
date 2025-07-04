package cn.com.chinahitech.bjmarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.com.chinahitech.bjmarket.course.Mapper")
@MapperScan("cn.com.chinahitech.bjmarket.information.*.mapper")
@MapperScan("cn.com.chinahitech.bjmarket.personal.*.mapper")
@MapperScan("cn.com.chinahitech.bjmarket.fileResources.mapper")
@MapperScan("cn.com.chinahitech.bjmarket.login.Mapper")
public class BjmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BjmarketApplication.class, args);
    }

}