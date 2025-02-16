package ReviewDBS.ReviewDB.Exception;

public class ReviewNotFound extends RuntimeException{
    public ReviewNotFound(String message){
        super(message); //Passes the error message to RuntimeException
    }
}
