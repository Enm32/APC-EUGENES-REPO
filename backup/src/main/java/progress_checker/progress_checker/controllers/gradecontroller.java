package progress_checker.progress_checker.controllers;

import org.springframework.web.bind.annotation.RestController;

import progress_checker.progress_checker.entities.gradeclasses;
import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.services.gradeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class gradecontroller {
@Autowired
gradeService gs;


@PostMapping("/new_grade")
public gradeclasses add_grade(@RequestBody gradeclasses new_grade) {
    
    return gs.add_grade(new_grade);
}
@GetMapping("/getgrades")
public gradeclasses get_grades(@RequestParam String param) {
    return gs.get_grade(param);
}
@GetMapping("/get_grade_students/{gradeName}")
public List<students> getGradeStudents(@PathVariable String gradeName){
    return gs.get_grade(gradeName).getGrade_students();
}

}
