package ReviewDBS.ReviewDB.Service;

import ReviewDBS.ReviewDB.Entity.Movie;
import ReviewDBS.ReviewDB.Exception.MovieNotFound;
import ReviewDBS.ReviewDB.Repository.MovieRepo;
import ReviewDBS.ReviewDB.Service.Interfaces.MovieInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImp implements MovieInterface {



    @Autowired
  private MovieRepo movieRepo;



//    @Override
//    public List<Movie> create(List<Movie> movie) {
//       return movieRepo.saveAll(movie);
//    }



    @Override
    public List<Movie> create(List<Movie> movies) {
        return movieRepo.saveAll(movies);
    }

    @Override
    public Movie get(Long id) {
        return movieRepo.findById(id).orElseThrow(()-> new MovieNotFound("This id has no movie review"+ id));
    }

//    @Override
//    public Movie get(Long id) {
//        return movieRepo.findById(id).orElseThrow(() -> new MovieNotFound("Movie not found by this id"));
//    }

    @Override
    public Movie Update(Movie movie, Long id) {
       Movie moviedetails = movieRepo.findById(id).orElseThrow(() ->  new MovieNotFound("Movie not found"+id));

       moviedetails.setTitle(movie.getTitle());
       moviedetails.setDirector(movie.getDirector());
       moviedetails.setGenre(movie.getGenre());

        return movieRepo.save(moviedetails);
    }

    @Override
    public Movie delete(Long id) {

      Movie dlt= movieRepo.findById(id).orElseThrow(() -> new MovieNotFound("Movie not found by this id"));
      movieRepo.deleteById(id);
      return dlt;

    }

    @Override
    public List<Movie> getall() {
      return  movieRepo.findAll();
    }
}
