package progress_checker.progress_checker.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class teachers {
@GeneratedValue(strategy = GenerationType.UUID)
@Id 
private UUID t_id;   
private String teacherName;
private String phone_number;
@OneToMany(mappedBy = "Teacher",fetch = FetchType.LAZY)
private List<subjects> Subjects;
}
