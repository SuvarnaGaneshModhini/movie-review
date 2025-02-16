package ReviewDBS.ReviewDB.Service.Interfaces;

import ReviewDBS.ReviewDB.Entity.Movie;

import java.util.List;

public interface MovieInterface {
   List <Movie>  create(List<Movie> movie);
    Movie get(Long id);
    Movie Update(Movie movie, Long id);
    Movie delete(Long id);
   List <Movie> getall();
}
