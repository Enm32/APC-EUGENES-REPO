package progress_checker.progress_checker.controllers;

import org.springframework.web.bind.annotation.RestController;

import progress_checker.progress_checker.request_models.add_rating_model;
import progress_checker.progress_checker.response_models.rating_response;
import progress_checker.progress_checker.services.ratingService;
import progress_checker.progress_checker.services.studentService;
import progress_checker.progress_checker.entities.ratings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ratings_controller {
    @Autowired
    ratingService rs;
    @Autowired
studentService ss_h;

@PostMapping("/addRating")
public ResponseEntity<rating_response> add_rating(@RequestBody add_rating_model adr) {
    
    return  rs.add_rating(adr);
    
}
@GetMapping("/get_student_ratings/{sName}")
public List<ratings> getstuRatings(@PathVariable String sName) {
 return ss_h.get_by_name(sName).getStudent_ratings();
  

}





}
