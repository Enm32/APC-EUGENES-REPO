package progress_checker.progress_checker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import progress_checker.progress_checker.entities.subjects;
import progress_checker.progress_checker.entities.teachers;
import progress_checker.progress_checker.request_models.teacher_sign_up;
import progress_checker.progress_checker.services.subjectService;
import progress_checker.progress_checker.services.teacherService;



@RestController
public class teachers_controller {

@Autowired
teacherService ts;
@Autowired
subjectService ssc;

@PostMapping("/addTeacher")
public String teacher_signup(@RequestBody teacher_sign_up tsu){
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


return "success";
}




}
