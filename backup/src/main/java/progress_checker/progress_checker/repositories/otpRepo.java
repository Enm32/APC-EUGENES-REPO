package progress_checker.progress_checker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import progress_checker.progress_checker.entities.Otp;

@Repository
public interface otpRepo extends JpaRepository<Otp,String> {

    @Query("select r from Otp r where r.otpToken=?1")
    Optional<Otp> findByOtpToken(String otpcode);
}