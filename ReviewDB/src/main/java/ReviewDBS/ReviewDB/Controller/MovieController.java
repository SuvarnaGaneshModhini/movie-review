package ReviewDBS.ReviewDB.Controller;


import ReviewDBS.ReviewDB.Entity.Movie;
import ReviewDBS.ReviewDB.Service.Interfaces.MovieInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {


    @Autowired
    private MovieInterface movieInterface;

    @PostMapping("/post")
    List<Movie> create(@RequestBody List<Movie> movies){
        return movieInterface.create(movies);
    }

    @GetMapping("/get/{id}")
    Movie get(@PathVariable Long id){
        return movieInterface.get(id);
    }

    @GetMapping("/getall")
  List<Movie> getall(){
        return movieInterface.getall();
  }

  @PutMapping("/put/{id}")
  Movie update(@RequestBody Movie movie, @PathVariable Long id ){
        return movieInterface.Update(movie,id);


  }

  @DeleteMapping("delete/{id}")
  Movie delete(@PathVariable Long id){
       return movieInterface.delete(id);
  }


}
