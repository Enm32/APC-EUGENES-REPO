package progress_checker.progress_checker.auth_config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import progress_checker.progress_checker.entities.students;
import progress_checker.progress_checker.entities.teachers;
import progress_checker.progress_checker.repositories.studentsRepo;
import progress_checker.progress_checker.repositories.teachersRepo;

@Service 
public class UserDetailsServiceImpl implements UserDetailsService  {
    @Autowired
    private studentsRepo userRepository;
    @Autowired
    private teachersRepo teachers_repository;
  
   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        teachers teacher=teachers_repository.findByTeachername(username).orElse(null);
        if (teacher == null) {
            // throw new UsernameNotFoundException("User not found");
            students user = userRepository.findByStudentname(username).orElse(null);
            
}else{
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
