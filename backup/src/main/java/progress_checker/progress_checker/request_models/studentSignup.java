package progress_checker.progress_checker.request_models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class studentSignup {
   
private String student_name;
private String parent_name;
private String studentGrade;
private String parentPhone;
private String emailAddress;
}
