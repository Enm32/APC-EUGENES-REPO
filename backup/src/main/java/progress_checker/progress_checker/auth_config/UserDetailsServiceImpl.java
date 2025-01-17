package progress_checker.progress_checker.auth_config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.repositories.studentsRepo;

@Service 
public class UserDetailsServiceImpl implements UserDetailsService  {
    @Autowired
    private studentsRepo userRepository;

  
   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       students user = userRepository.findByStudentname(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        //;
        return User.builder()
                .username(username)
                .password(username)
                .roles("user")
                .build();
    }
}
