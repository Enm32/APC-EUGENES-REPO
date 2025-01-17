package progress_checker.progress_checker.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class students {

 @Id     
private String student_name;
@JsonIgnore
private String parent_name;
@JsonIgnore
private String emailAddress;
@ManyToOne
@JsonIgnore
private gradeclasses studentGrade;
@JsonIgnore
private String parent_phone;
@OneToMany(mappedBy = "Student",fetch=FetchType.LAZY)
@JsonIgnore
private  List<ratings> student_ratings;
}
