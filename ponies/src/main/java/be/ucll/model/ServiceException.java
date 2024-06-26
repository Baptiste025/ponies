package be.ucll.model;

public class ServiceException extends RuntimeException{
    public String field;

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String field, String message){
        super(message);
        this.field = field;
    }

    public String getField() {
        return this.field;
    }
}
