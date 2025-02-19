package ReviewDBS.ReviewDB.Controller;


import ReviewDBS.ReviewDB.Dto.LoginDto;
import ReviewDBS.ReviewDB.Entity.User;
import ReviewDBS.ReviewDB.Service.Interfaces.UserInterface;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest hsr){
        return (CsrfToken)hsr.getAttribute("_csrf");
    }

}


