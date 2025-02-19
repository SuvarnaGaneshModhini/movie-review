package ReviewDBS.ReviewDB.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private String genre;
    private String director;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL ,orphanRemoval = true )       //used in JPA to automatically remove child entities when they are no longer referenced by the parent. It applies to OneToOne and OneToMany relationships.
    private List<Review> reviews = new ArrayList<>();



    //  Reviews Here....


    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


}

