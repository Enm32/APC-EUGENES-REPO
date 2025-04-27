package progress_checker.progress_checker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import progress_checker.progress_checker.auth_config.JwtService;
import progress_checker.progress_checker.auth_config.teacherAuthenticationManager;
import progress_checker.progress_checker.entities.subjects;
import progress_checker.progress_checker.entities.teachers;
import progress_checker.progress_checker.request_models.teacher_sign_up;
import progress_checker.progress_checker.response_models.signUpresponse;
import progress_checker.progress_checker.response_models.tokenresponse;
import progress_checker.progress_checker.services.subjectService;
import progress_checker.progress_checker.services.teacherService;



@RestController
public class teachers_controller {
    @Autowired
    private JwtService jwtService;
@Autowired
teacherService ts;
@Autowired
subjectService ssc;

   @Autowired
    private teacherAuthenticationManager authenticationManager;



@PostMapping("/addTeacher")
public ResponseEntity<signUpresponse> teacher_signup(@RequestBody teacher_sign_up tsu){
       List<String> sbd=tsu.getT_subjects();
       List<subjects> sdcv=ssc.getsubs(sbd);

teachers newTeachers=teachers.builder()
.phone_number(tsu.getPhone())
.teacherName(tsu.getFull_name())
.build();
 ts.add_teacher(newTeachers);

for (subjects subjects : sdcv) {
    subjects.setTeacher(newTeachers);
    ssc.update_subject(subjects);
}
 //subjects scss=ssc.get_subject(sbd.getFirst());


signUpresponse srp=signUpresponse.builder().message("success").build();
   return ResponseEntity.status(200).body(srp);
}

@PostMapping("/teachers/auth/get_token")
public ResponseEntity<tokenresponse> tokengen(@RequestParam String username) {
     Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,username));
        SecurityContextHolder.getContext().setAuthentication(authentication);

       // UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(new tokenresponse(HttpStatus.OK.value(), jwtService.generateToken(username)));
    
}


}
