package progress_checker.progress_checker.request_models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class add_rating_model {
private String subject;
private String topic;
private String topic_rating;
private String student_name;


}
