package ReviewDBS.ReviewDB.Repository;

import ReviewDBS.ReviewDB.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
