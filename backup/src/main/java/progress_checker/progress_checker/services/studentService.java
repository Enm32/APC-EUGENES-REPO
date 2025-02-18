package progress_checker.progress_checker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.entities.gradeclasses;
import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.repositories.studentsRepo;
import progress_checker.progress_checker.request_models.studentSignup;
import progress_checker.progress_checker.response_models.NotificationResponse;
import progress_checker.progress_checker.response_models.signUpresponse;

import java.util.List;

@Service
public class studentService {

@Autowired
studentsRepo sr;
@Autowired
gradeService gser;

public ResponseEntity<signUpresponse> add_student(studentSignup sSu) {

   gradeclasses s_grade=gser.get_grade(sSu.getStudentGrade());
   students newStudents=students.builder().student_name(sSu.getStudent_name()).parent_name(sSu.getParent_name()).parent_phone(sSu.getParentPhone()).studentGrade(s_grade).student_name(sSu.getStudent_name()).emailAddress(sSu.getEmailAddress()).notificationToken(sSu.getNotif_token()).build();
   sr.saveAndFlush(newStudents);
   signUpresponse nm=signUpresponse.builder().message("success").build();
   return ResponseEntity.status(200).body(nm);

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
public ResponseEntity<NotificationResponse> get_notifToken(String name){
students st=sr.findByStudentname(name).orElse(null);
return ResponseEntity.status(200).body(new NotificationResponse(HttpStatus.OK.value(), st.getNotificationToken()));
}


}