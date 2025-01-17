package progress_checker.progress_checker.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class ratings {
 @GeneratedValue(strategy = GenerationType.UUID)
 @Id 
 @JsonIgnore
private UUID id;
@JsonIgnore
private String subject;

private String topic ;
private String rating;

@ManyToOne
@JsonIgnore
private students Student;
}
