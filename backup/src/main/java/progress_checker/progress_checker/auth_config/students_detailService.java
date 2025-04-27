package progress_checker.progress_checker.auth_config;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.repositories.studentsRepo;

@Service 
public class students_detailService implements UserDetailsService  {
    @Autowired
    private studentsRepo userRepository;
  
   @Override
    public Userdetails loadUserByUsername(String username) throws UsernameNotFoundException {
        students st=userRepository.findByStudentname(username).orElse(null);
        if (st == null) 
            {
                return null;
            }
          
            

    
     
        return Userdetails.builder()
                .username(username)
                .password(username)
                .authorities(Set.of(new SimpleGrantedAuthority("user")))
                .build();
    }
}
