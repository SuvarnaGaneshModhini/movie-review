package ReviewDBS.ReviewDB.Controller;


import ReviewDBS.ReviewDB.Dto.ReviewDto;
import ReviewDBS.ReviewDB.Entity.Review;
import ReviewDBS.ReviewDB.Service.Interfaces.ReviewInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviewapi")



public class ReviewController {

    @Autowired
    private ReviewInterface reviewInterface;

    @PostMapping("/postrev")
   Review create(@RequestBody Review review){
     return   reviewInterface.create(review);
   }

//    List<Review> create(@RequestBody List<Review> reviews){
//        return reviewInterface.postdata(reviews);
//    }

    @GetMapping("/getalldata")
    List<Review> getall(){
        return reviewInterface.getall();
    }

    @GetMapping("/getbyid/{id}")
    Review getbyid(@PathVariable Long id){
        return reviewInterface.getbyid(id);
    }

    @PutMapping("/putdata/{id}")
    Review update(@RequestBody Review review , @PathVariable Long id){
        return reviewInterface.update(review,id);
    }


    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Long id){
        reviewInterface.Delete(id);
        return ResponseEntity.ok("Successfully deleted the data");
    }

    @PostMapping("/post/review")
    ResponseEntity<String> addReview(@RequestParam long userId, @RequestParam long movieId, @RequestBody ReviewDto reviewDto){
        return reviewInterface.addReview(userId,movieId,reviewDto);
    }


}
