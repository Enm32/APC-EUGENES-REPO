package progress_checker.progress_checker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import progress_checker.progress_checker.entities.subjects;
import progress_checker.progress_checker.request_models.subjectsModel;
import progress_checker.progress_checker.services.subjectService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class subjectsController {
    @Autowired
    subjectService subService;
    @PostMapping("/addsubject")
    public subjects addSubject(@RequestBody subjectsModel newSub) {
      return  subService.add_subject(newSub);
        
        
    }
    

}
