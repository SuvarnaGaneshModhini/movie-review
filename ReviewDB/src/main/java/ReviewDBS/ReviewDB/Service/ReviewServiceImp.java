package ReviewDBS.ReviewDB.Service;

import ReviewDBS.ReviewDB.Entity.Review;
import ReviewDBS.ReviewDB.Exception.ReviewNotFound;
import ReviewDBS.ReviewDB.Repository.ReviewRepo;
import ReviewDBS.ReviewDB.Service.Interfaces.ReviewInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImp implements ReviewInterface {

    @Autowired
    private ReviewRepo reviewRepo;

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

        return reviewRepo.findById(id).orElseThrow(()-> new ReviewNotFound("Review not found by this id"+id));

    }

    @Override
    public Review update(Review review, Long id) {
      Review rev=  reviewRepo.findById(id).orElseThrow(()-> new ReviewNotFound("Review not found by this id"+id));

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
//
//    @Override
//    public List<Review> postdata(List<Review> reviews) {
//        return reviewRepo.saveAll(reviews);
//    }
}
