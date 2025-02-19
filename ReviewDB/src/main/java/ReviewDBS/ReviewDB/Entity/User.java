package ReviewDBS.ReviewDB.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // Avoid conflict with SQL reserved keywords
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;



    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL ,orphanRemoval = true )
    private List<Review> reviews = new ArrayList<>();






    // Default constructor (required by JPA)
    public User() {}

    // Parameterized constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
