package domain;

public class DomainException extends RuntimeException{
    String message;
    public DomainException(String message) {
        super(message);
    }
}

