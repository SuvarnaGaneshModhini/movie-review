package ReviewDBS.ReviewDB.Service.Interfaces;

import ReviewDBS.ReviewDB.Dto.LoginDto;
import ReviewDBS.ReviewDB.Entity.Review;
import ReviewDBS.ReviewDB.Entity.User;
import org.springframework.http.ResponseEntity;

public interface UserInterface {

    User create(User user);

    ResponseEntity<String> login(LoginDto loginDTO);


}
