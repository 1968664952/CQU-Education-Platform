package cn.com.chinahitech.bjmarket.common;

public class Result<T> {
    private Integer status;     // 状态码，如 200、400、500
    private String message;   // 提示信息
    private T data;           // 返回数据

    // 构造函数私有化，使用静态方法创建
    private Result(String message, T data, Integer status) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // 成功返回
    public static <T> Result<T> success(T data) {
        return new Result<>( "操作成功", data,200);
    }

    // 失败返回
    public static <T> Result<T> error(String message) {
        return new Result<>(message, null,500);
    }

    // 自定义状态码与消息
    public static <T> Result<T> build(Integer status, String message, T data) {
        return new Result<>(message, data, status);
    }

    // Getter 和 Setter
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}