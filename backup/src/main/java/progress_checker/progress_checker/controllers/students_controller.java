package progress_checker.progress_checker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import progress_checker.progress_checker.entities.gradeclasses;
import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.request_models.studentSignup;
import progress_checker.progress_checker.services.studentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@RestController
public class students_controller {

@Autowired
studentService ss;


@PostMapping("/addStudent")
public String parent_signup(@RequestBody studentSignup ssu){
return ss.add_student(ssu);

}
@GetMapping("/get_by_grade")
public List<students> get_grade_Students(@RequestBody gradeclasses grade) {
    return ss.get_by_grade(grade);
}
@GetMapping("/get_by_name/{sname}")
public students getbyname(@PathVariable String sname) {
    return ss.get_by_name(sname);
}

@GetMapping("/getallStudents")
public List<students> getallstu() {
    return ss.getAllStudents();
}
}
