package progress_checker.progress_checker.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import progress_checker.progress_checker.entities.teachers;
import progress_checker.progress_checker.repositories.teachersRepo;

@Service
public class teacherService {
    @Autowired
    teachersRepo tr;
    @Autowired
    subjectService subject_service;

 public String add_teacher(teachers tsu_model){
 
    
    
    tr.saveAndFlush(tsu_model);
     
    
 
  return "success";
    
    
   
 }





}
