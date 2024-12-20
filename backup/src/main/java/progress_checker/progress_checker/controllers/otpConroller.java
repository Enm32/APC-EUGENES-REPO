package progress_checker.progress_checker.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import progress_checker.progress_checker.emaildetails;
import progress_checker.progress_checker.entities.Otp;
import progress_checker.progress_checker.services.emailService;
import progress_checker.progress_checker.services.otpService;

@RestController
public class otpConroller {
    @Autowired
    otpService oService;
    @Autowired
    emailService e_service;

    @PostMapping("/verify_otp")
    public ResponseEntity<?>
    verification(@RequestParam String code){
        return oService.verify_otp(code);
    }

    @PostMapping("/send_otp")
    public ResponseEntity<?> sendOtp(@RequestParam String email){
        String code=otpgenerator();
        emaildetails ed= emaildetails.builder()
                .recipient(email)
                .subject("verification code")
                .msgBody(code)
                .build();
        Otp new_otp= Otp.builder()
                .email(email)
                .otpToken(code)
                .build();
        oService.add_otp(new_otp);
        return  e_service.sendSimpleMail(ed);


    }




    public String otpgenerator(){
        Random rand = new Random();
        int rand_int = rand.nextInt(1000000);
        String otp= String.format("%06d", rand_int);;
        return otp;
    }
}
