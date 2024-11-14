package progress_checker.progress_checker.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import progress_checker.progress_checker.entities.teachers;
@Repository
public interface teachersRepo extends JpaRepository<teachers,UUID>{

}
