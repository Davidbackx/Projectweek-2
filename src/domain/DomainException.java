package domain;

public class DomainException extends RuntimeException{
    String message; //?? mag weg
    public DomainException(String message) {
        super(message);
    }
    public DomainException(){
    }
}

