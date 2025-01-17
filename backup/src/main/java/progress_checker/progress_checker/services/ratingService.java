package progress_checker.progress_checker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import progress_checker.progress_checker.entities.ratings;
import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.repositories.ratingsRepo;
import progress_checker.progress_checker.request_models.add_rating_model;
import progress_checker.progress_checker.response_models.rating_response;

@Service
public class ratingService {
@Autowired
ratingsRepo ratings_repo;
@Autowired
studentService sess;

public ResponseEntity<rating_response>  add_rating(add_rating_model stu_rate){
students rated_student=sess.get_by_name(stu_rate.getStudent_name());
ratings new_rating=ratings.builder()
                        .Student(rated_student)
                        .rating(stu_rate.getTopic_rating())
                        .subject(stu_rate.getSubject())
                        .topic(stu_rate.getTopic())
                        .build();

 ratings_repo.saveAndFlush(new_rating);
 rating_response sd=rating_response.builder().student_rating(stu_rate.getTopic_rating()).topic_name(stu_rate.getTopic()).build();
 return ResponseEntity.status(200).body(sd);
}

public  List<ratings> get_rating_by_subject(String subject){
    return ratings_repo.findBySubject(subject).orElse(null);
}

public List<ratings> get_rate(String a,String b){
   students df= sess.get_by_name(b);
 //  System.out.println(df);
    return ratings_repo.findBystudentandsubject(a, df).orElse(null);
}

}
