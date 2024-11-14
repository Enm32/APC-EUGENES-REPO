package progress_checker.progress_checker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import progress_checker.progress_checker.entities.subjects;

@Repository
public interface subjectsRepo extends JpaRepository<subjects,String> {
@Query("select r from subjects r where sname=?1") 
Optional<subjects>  findBySname(String subject_name);


}
