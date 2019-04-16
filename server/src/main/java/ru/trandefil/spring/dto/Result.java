package ru.trandefil.spring.dto;

public class Result {

    private Boolean success;

    private String message;

    public Result(Boolean success) {
        this.success = success;
    }

    public Result(Exception e){
        this.message = e.getMessage();
    }

    public Result() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }

}

