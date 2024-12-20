package progress_checker.progress_checker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.emaildetails;
import progress_checker.progress_checker.response_models.otpResponse;

@Service
public class emailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;
    public ResponseEntity<?> sendSimpleMail(emaildetails details)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return ResponseEntity.status(200).body(new otpResponse(HttpStatus.OK.value(),"Mail Sent Successfully..."));

        }


        catch (Exception e) {
            return ResponseEntity.status(500).body(new otpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error while Sending Mail"));
        }
    }
}
