package progress_checker.progress_checker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class emaildetails {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}