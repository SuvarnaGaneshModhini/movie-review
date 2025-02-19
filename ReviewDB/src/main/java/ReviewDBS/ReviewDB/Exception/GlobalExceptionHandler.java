package ReviewDBS.ReviewDB.Exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ReviewNotFound.class)
    public ResponseEntity<String> handleMovieNotFoundException(ReviewNotFound ex1) {
        return new ResponseEntity<>(ex1.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleMovieNotFoundException(UserNotFound ex2) {
        return new ResponseEntity<>(ex2.getMessage(), HttpStatus.NOT_FOUND);
    }

}
