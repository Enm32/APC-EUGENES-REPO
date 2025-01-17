package progress_checker.progress_checker.repositories;

import java.util.UUID;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import progress_checker.progress_checker.entities.ratings;
import progress_checker.progress_checker.entities.students;

import java.util.List;


@Repository
public interface ratingsRepo extends JpaRepository<ratings,UUID> {


Optional<List<ratings>>  findBySubject(String subject);
@Query("select g from ratings g where subject=?1 and Student=?2")
Optional<List<ratings>>  findBystudentandsubject(String sub,students stud);
}
