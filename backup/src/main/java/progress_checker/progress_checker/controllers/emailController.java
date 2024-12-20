package progress_checker.progress_checker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import progress_checker.progress_checker.emaildetails;
import progress_checker.progress_checker.services.emailService;

@RestController
public class emailController {
    @Autowired
    private emailService email_service;
    
    @PostMapping("/sendMail")
    public ResponseEntity<?>
    sendMail(@RequestBody emaildetails details)
    {
        return email_service.sendSimpleMail(details);


    }
}
