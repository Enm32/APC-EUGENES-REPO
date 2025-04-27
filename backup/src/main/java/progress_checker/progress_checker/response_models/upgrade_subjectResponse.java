package progress_checker.progress_checker.response_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class upgrade_subjectResponse {
    private int statusCode;
    private String message;

}
