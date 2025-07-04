package cn.com.chinahitech.bjmarket.login.entity;


public class Administrator {
    private Integer administratorId;
    private String passwordHash;

    // Getters and Setters
    public Integer getAdministratorId() { return administratorId; }
    public void setAdministratorId(Integer administratorId) { this.administratorId = administratorId; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
}
