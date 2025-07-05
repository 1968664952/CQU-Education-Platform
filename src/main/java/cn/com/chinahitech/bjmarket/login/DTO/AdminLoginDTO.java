package cn.com.chinahitech.bjmarket.login.DTO;

public class AdminLoginDTO {
    private Integer administratorId;
    private String password;

    public Integer getAdministratorId() { return administratorId; }
    public void setAdministratorId(Integer administratorId) { this.administratorId = administratorId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
