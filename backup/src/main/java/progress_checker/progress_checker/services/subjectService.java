package progress_checker.progress_checker.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.entities.gradeclasses;
import progress_checker.progress_checker.entities.subjects;
import progress_checker.progress_checker.repositories.subjectsRepo;
import progress_checker.progress_checker.request_models.subjectsModel;

@Service
public class subjectService {
@Autowired
subjectsRepo subjects_repo;
@Autowired
gradeService gss;
public subjects get_subject(String name){
//  kkkfkfd
  return  subjects_repo.findBySname(name).orElse(null);
}

public subjects add_subject(subjectsModel newSubject){
   gradeclasses gc=gss.get_grade(newSubject.getGrade());
   subjects newsubb=subjects.builder()
                           .sname(newSubject.getName())
                           .subjectGrade(gc)
                           .build();
    return  subjects_repo.save(newsubb);
 }
public String update_subject(subjects nm){
   subjects sbcc=subjects_repo.findBySname(nm.getSname()).orElse(null);
   sbcc.setTeacher(nm.getTeacher());
    subjects_repo.saveAndFlush(sbcc);
    return "ok";
}
// public String update_subject(List<String> nm){
//    List<subjects> sdcv=new ArrayList<>();
//    for (String string : nm) {
      
//    }
//    subjects sbcc=subjects_repo.findBySname(nm.getSname()).orElse(null);
//    sbcc.setTeacher(nm.getTeacher());
//     subjects_repo.saveAndFlush(sbcc);
//     subjects_repo.findAllById(nm);
//     return "ok";
// }

public List<subjects> getsubs(List<String> nmds){
   List<subjects> sdcv=new ArrayList<>();
      for (String string : nmds) {
         sdcv.add(subjects_repo.findBySname(string).orElse(null));
      }
     return sdcv;
}

}
