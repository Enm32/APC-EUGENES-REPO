package progress_checker.progress_checker.repositories;

import java.util.UUID;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import progress_checker.progress_checker.entities.ratings;
import java.util.List;


@Repository
public interface ratingsRepo extends JpaRepository<ratings,UUID> {


Optional<List<ratings>>  findBySubject(String subject);


}
