package cn.com.chinahitech.bjmarket.common;

public class Result<T> {
    private Integer code;     // 状态码，如 200、400、500
    private String message;   // 提示信息
    private T data;           // 返回数据

    // 构造函数私有化，使用静态方法创建
    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功返回
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    // 失败返回
    public static <T> Result<T> error(T data) {
        return new Result<>(500, "操作失败", data);
    }
    // 失败返回（只传错误消息，无 data）
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    // 自定义状态码与消息
    public static <T> Result<T> build(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }

    // Getter 和 Setter
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}