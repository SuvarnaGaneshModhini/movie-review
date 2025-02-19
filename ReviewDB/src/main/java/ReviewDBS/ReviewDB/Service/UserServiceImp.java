package ReviewDBS.ReviewDB.Service;

import ReviewDBS.ReviewDB.Dto.LoginDto;
import ReviewDBS.ReviewDB.Entity.User;
import ReviewDBS.ReviewDB.Exception.UserNotFound;
import ReviewDBS.ReviewDB.Repository.UserRepo;
import ReviewDBS.ReviewDB.Service.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp  implements UserInterface {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User create(User user) {

        if (userRepo.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email is already exists");
        }
        user.setUserId(null);  // Ensure Hibernate treats it as a new user manaki ikkada null rayakapothe adi kotha user kinda consider cheyyadu

        return userRepo.save(user);
    }

    @Override
    public ResponseEntity<String> login(LoginDto loginDTO) throws UserNotFound {
        List<User> listUser = userRepo.findAll();
        for(User usr: listUser) System.out.println(usr);

       User user =  userRepo.findByEmail(loginDTO.getEmail());
       if(user == null){
           throw new UserNotFound("User Not found!!");
       }
       if(user.getPassword().equals(loginDTO.getPassword())) return ResponseEntity.ok("Login Successfull");
       else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Password");
    }


}
