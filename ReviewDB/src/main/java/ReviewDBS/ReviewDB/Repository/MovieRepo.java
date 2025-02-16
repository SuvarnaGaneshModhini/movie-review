package ReviewDBS.ReviewDB.Repository;

import ReviewDBS.ReviewDB.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}
