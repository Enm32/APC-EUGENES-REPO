package progress_checker.progress_checker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import progress_checker.progress_checker.auth_config.JwtService;
import progress_checker.progress_checker.auth_config.studentsAuthenticationManager;
import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.request_models.studentSignup;
import progress_checker.progress_checker.response_models.NotificationResponse;
import progress_checker.progress_checker.response_models.signUpresponse;
import progress_checker.progress_checker.response_models.tokenresponse;
import progress_checker.progress_checker.services.studentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.Authentication;

import java.util.List;



@RestController
public class students_controller {

@Autowired
studentService ss;
  @Autowired
    private studentsAuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

@PostMapping("/addStudent")
public ResponseEntity<signUpresponse> parent_signup(@RequestBody studentSignup ssu){
return ss.add_student(ssu);

}
@GetMapping("/get_by_grade")
public List<students> get_grade_Students(@RequestParam("grade") String grade) {
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

@PostMapping("/auth/get_token")
public ResponseEntity<tokenresponse> tokengen(@RequestParam String username) {
     Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,username));
        SecurityContextHolder.getContext().setAuthentication(authentication);

       // UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(new tokenresponse(HttpStatus.OK.value(), jwtService.generateToken(username)));
    
}

@GetMapping("/active")
public String getact() {
    Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    return userDetails.getUsername();
}
@GetMapping("/getNotifToken")
public ResponseEntity<NotificationResponse> getNotificationtoken(@RequestParam String studentName) {
    return ss.get_notifToken(studentName);
}

@PostMapping("/upgradeStudent/{id1}/{id2}")
public ResponseEntity<?> up_grade(@PathVariable String id1,@PathVariable String id2 ){
return ss.update_student(id1,id2);

}



}
