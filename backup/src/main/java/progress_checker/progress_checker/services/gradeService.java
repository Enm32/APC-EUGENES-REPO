package progress_checker.progress_checker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.entities.gradeclasses;
import progress_checker.progress_checker.repositories.gradeclassesRepo;

@Service
public class gradeService {
@Autowired
gradeclassesRepo gcr;

public gradeclasses add_grade(gradeclasses newgrade){
return gcr.save(newgrade);
}

public gradeclasses get_grade(String grade_name){
  
    return gcr.findByGname(grade_name).orElse(null);
    }



}
