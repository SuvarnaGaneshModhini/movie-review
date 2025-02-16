package ReviewDBS.ReviewDB.Exception;

public class MovieNotFound extends RuntimeException{
    public MovieNotFound(String message) {
        super(message); //Passes the error message to RuntimeException
    }
}
