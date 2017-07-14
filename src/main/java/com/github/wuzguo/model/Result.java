package com.github.wuzguo.model;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.model
 */
public class Result {

    private int id;

    private boolean success;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(int id, boolean success, String message) {
        this.id = id;
        this.success = success;
        this.message = message;
    }

    public Result(int id, boolean success, String message, Object data) {
        this.id = id;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
