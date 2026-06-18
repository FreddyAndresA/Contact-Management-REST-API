package ContactManagement.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timestamp;
    private List<String> errors;


    public ValidationErrorResponse() {
    }


    public ValidationErrorResponse(String message, int status, LocalDateTime timestamp, List<String> errors) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.errors = errors;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}
