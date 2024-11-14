package progress_checker.progress_checker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.entities.gradeclasses;
import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.repositories.studentsRepo;
import progress_checker.progress_checker.request_models.studentSignup;
import java.util.List;

@Service
public class studentService {

@Autowired
studentsRepo sr;
@Autowired
gradeService gser;
public String add_student(studentSignup sSu){
   gradeclasses s_grade=gser.get_grade(sSu.getStudentGrade());

   students newStudents=students.builder().student_name(sSu.getStudent_name()).parent_name(sSu.getParent_name()).parent_phone(sSu.getParentPhone()).studentGrade(s_grade).student_name(sSu.getStudent_name()).build();
   sr.saveAndFlush(newStudents);
   return "success";
}

public students get_by_name(String name){
   return sr.findByStudentname(name).orElse(null);
}
public List<students> get_by_grade(gradeclasses sg){
   return sr.findByStudentGrade(sg).orElse(null);
}

public List<students> getAllStudents(){
   return sr.findAll();
}



}