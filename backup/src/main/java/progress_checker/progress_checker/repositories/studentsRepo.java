package progress_checker.progress_checker.repositories;



import java.util.Optional;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import progress_checker.progress_checker.entities.gradeclasses;
import progress_checker.progress_checker.entities.students;


@Repository
public interface studentsRepo extends JpaRepository<students,String> {

@Query("select r from students r where student_name=?1") 
Optional<students>  findByStudentname(String stu_name);
@Query("select r from students r where studentGrade=?1") 
Optional<List<students>>  findByStudentGrade(gradeclasses grade);







}
