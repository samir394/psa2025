package in.sameer.exception;



public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String msg) {
        super(msg);
    }
}
