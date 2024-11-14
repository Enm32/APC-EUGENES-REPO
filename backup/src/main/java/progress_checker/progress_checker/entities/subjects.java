package progress_checker.progress_checker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class subjects {
 @Id   
private String sname;

@ManyToOne
@JsonIgnore
private teachers Teacher;
@ManyToOne
private gradeclasses subjectGrade;

}
