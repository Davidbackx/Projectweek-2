package db.domain;

public class DbException extends RuntimeException {
    String message;
    public DbException(String message){
        super(message);
    }
    public DbException(){

    }
}
