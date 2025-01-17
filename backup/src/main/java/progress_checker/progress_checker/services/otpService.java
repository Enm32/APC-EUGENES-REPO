package progress_checker.progress_checker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.entities.Otp;
import progress_checker.progress_checker.repositories.otpRepo;
import progress_checker.progress_checker.response_models.otpResponse;

@Service
public class otpService {
    @Autowired
    otpRepo oRepo;
    public ResponseEntity<?> verify_otp(String code){
       Otp tkn= oRepo.findByOtpToken(code).orElse(null);
       if (tkn != null){
           oRepo.delete(tkn);
           return ResponseEntity.status(HttpStatus.OK).body(new otpResponse(HttpStatus.OK.value(), "verification success"));
       }

    return ResponseEntity.status(HttpStatus.OK).body(new otpResponse(HttpStatus.OK.value(), "verification failed")) ;
    }
    public String add_otp(Otp oTP){
        oRepo.save(oTP);
        return "success";
    }
}
