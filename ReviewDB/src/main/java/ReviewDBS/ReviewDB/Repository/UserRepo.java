package ReviewDBS.ReviewDB.Repository;

import ReviewDBS.ReviewDB.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    User findByEmail(String email); // For Spring Security Login
//    Optional<User> findByEmail(String email); // For Login Using LoginDto
}

