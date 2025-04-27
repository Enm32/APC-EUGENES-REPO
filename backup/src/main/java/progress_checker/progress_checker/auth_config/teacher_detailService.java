package progress_checker.progress_checker.auth_config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import progress_checker.progress_checker.entities.teachers;
import progress_checker.progress_checker.repositories.teachersRepo;
import org.springframework.stereotype.Service;

@Service 
public class teacher_detailService implements UserDetailsService  {
    @Autowired
    private teachersRepo teachers_repository;
    @Override
    public teacher_UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        teachers tch=teachers_repository.findByTeachername(username).orElse(null);
        if (tch == null) 
           {
            return null;
           }
           
            

        return teacher_UserDetails.builder()
                .username(username)
                .password(username)
                .authorities(Set.of(new SimpleGrantedAuthority("user")))
                .build();
    }

}
