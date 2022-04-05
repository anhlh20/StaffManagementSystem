package exception;

public class MyValidateException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public MyValidateException(String msg){
        super(msg);
    }
}
