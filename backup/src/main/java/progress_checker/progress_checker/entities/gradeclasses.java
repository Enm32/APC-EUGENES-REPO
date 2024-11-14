package progress_checker.progress_checker.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class gradeclasses {

 @Id  
private String gname;

@OneToMany(mappedBy = "studentGrade",fetch = FetchType.LAZY)
private List<students> grade_students;

@OneToMany(mappedBy = "subjectGrade",fetch = FetchType.LAZY)
@JsonIgnore
private List<subjects> grade_subjects;
}
