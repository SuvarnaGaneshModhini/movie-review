package ReviewDBS.ReviewDB.Service;

import ReviewDBS.ReviewDB.Dto.ReviewDto;
import ReviewDBS.ReviewDB.Entity.Movie;
import ReviewDBS.ReviewDB.Entity.Review;
import ReviewDBS.ReviewDB.Entity.User;
import ReviewDBS.ReviewDB.Exception.ReviewNotFound;
import ReviewDBS.ReviewDB.Exception.UserNotFound;
import ReviewDBS.ReviewDB.Repository.MovieRepo;
import ReviewDBS.ReviewDB.Repository.ReviewRepo;
import ReviewDBS.ReviewDB.Repository.UserRepo;
import ReviewDBS.ReviewDB.ReviewDbApplication;
import ReviewDBS.ReviewDB.Service.Interfaces.ReviewInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImp implements ReviewInterface {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Review create(Review review) {
        return reviewRepo.save(review);

    }

    @Override
    public List<Review> getall() {
        return reviewRepo.findAll();

    }

    @Override
    public Review getbyid(Long id) {

        return reviewRepo.findById(id).orElseThrow(() -> new ReviewNotFound("Review not found by this id" + id));

    }

    @Override
    public Review update(Review review, Long id) {
        Review rev = reviewRepo.findById(id).orElseThrow(() -> new ReviewNotFound("Review not found by this id" + id));

        rev.setMovieName(review.getMovieName());
        rev.setRating(review.getRating());
        rev.setReviewerName(review.getReviewerName());
        rev.setReviewText(review.getReviewText());

        return reviewRepo.save(rev);
    }

    @Override
    public String Delete(Long id) {

        reviewRepo.deleteById(id);
        return "Successfully deleted the data";
    }

    @Override
    public ResponseEntity<String> addReview(Long userId, Long movieId, ReviewDto reviewDto) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFound("User Not found"));
        Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new UserNotFound("Movie Not found"));
        Review review = new Review();
        review.setMovieName(reviewDto.getMovieName());
        review.setReviewText(reviewDto.getReviewText());
        review.setReviewerName(reviewDto.getReviewerName());
        review.setRating(reviewDto.getRating());
        review.setMovie(movie);
        review.setUser(user);
        reviewRepo.save(review);
        System.out.println(review);
//        System.out.println(user);

        return ResponseEntity.ok("Review Submited Successfully");
    }
}