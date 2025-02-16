package ReviewDBS.ReviewDB.Controller;


import ReviewDBS.ReviewDB.Dto.LoginDto;
import ReviewDBS.ReviewDB.Entity.User;
import ReviewDBS.ReviewDB.Service.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class UserController {


    @Autowired
    private UserInterface userInterface;

@PostMapping("/posting")
    User create (@RequestBody User user){
        return userInterface.create(user);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDTO) {
        return userInterface.login(loginDTO);
    }
}


