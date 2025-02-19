package ReviewDBS.ReviewDB.Service;

import ReviewDBS.ReviewDB.Entity.User;
import ReviewDBS.ReviewDB.Entity.UserPrinciple;
import ReviewDBS.ReviewDB.Exception.UserNotFound;
import ReviewDBS.ReviewDB.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFound {
        User user = userRepo.findByEmail(username);

        if(user==null) throw new UserNotFound("User Not Found");


        return new UserPrinciple(user);
    }
}
