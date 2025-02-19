package ReviewDBS.ReviewDB.Service.Interfaces;

import ReviewDBS.ReviewDB.Dto.ReviewDto;
import ReviewDBS.ReviewDB.Entity.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewInterface {


    //List<Review> postdata(List<Review> reviews);
    Review create(Review review);
   List<Review> getall();
   Review getbyid(Long id);
   Review update(Review review, Long id);

   String Delete(Long id);
    ResponseEntity<String> addReview(Long userId, Long movieId, ReviewDto reviewDto);
}
