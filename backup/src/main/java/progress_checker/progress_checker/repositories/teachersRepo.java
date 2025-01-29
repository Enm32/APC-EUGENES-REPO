package progress_checker.progress_checker.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import progress_checker.progress_checker.entities.teachers;
@Repository
public interface teachersRepo extends JpaRepository<teachers,UUID>{

@Query("select r from teachers r where teacherName=?1") 
Optional<teachers>  findByTeachername(String t_name);
}
