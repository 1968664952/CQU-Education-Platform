package cn.com.chinahitech.bjmarket.login.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String studentId;
    private String password;

    // Getter 和 Setter
}