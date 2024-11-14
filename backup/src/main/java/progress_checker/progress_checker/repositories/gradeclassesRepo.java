package progress_checker.progress_checker.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import progress_checker.progress_checker.entities.gradeclasses;
@Repository
public interface gradeclassesRepo extends JpaRepository<gradeclasses,String>{
 @Query("select r from gradeclasses r where gname=?1")   
Optional<gradeclasses> findByGname(String grade_name);
}
