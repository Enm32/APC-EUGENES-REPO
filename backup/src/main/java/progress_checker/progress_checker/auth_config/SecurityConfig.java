package progress_checker.progress_checker.auth_config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private students_detailService userDetailsService;

    @Autowired
    private teacher_detailService tsc;
    



      @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http.csrf(csrf -> csrf.disable())
                  .cors(httpSecurityCorsConfigurer -> {
                      CorsConfiguration configuration = new CorsConfiguration();
                      configuration.applyPermitDefaultValues();
                      configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
                      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                      source.registerCorsConfiguration("/**", configuration);
                      httpSecurityCorsConfigurer.configurationSource(source);
                  }).
                  //    authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                  //        authorizationManagerRequestMatcherRegistry.anyRequest().permitAll();

                  //    })
                 authorizeHttpRequests(auth -> {
              auth
                      .requestMatchers("/auth/get_token","/addStudent","/addTeacher","/send_otp","/notification","/verify_otp","/new_grade","/addsubject","/teachers/auth/get_token","/getallStudents").permitAll()
                      .anyRequest().authenticated();
          })
                  .sessionManagement(httpSecuritySessionManagementConfigurer -> {
                      httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                  });


          http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


       return http.build();
    }
   
    
    @SuppressWarnings("deprecation")
    @Bean
        public PasswordEncoder passwordEncoder() {
            // return new BCryptPasswordEncoder();
           return NoOpPasswordEncoder.getInstance();
        }
    
    // @Primary
    // @Bean
    // public AuthenticationManager student_authenticationManager(HttpSecurity http,PasswordEncoder passwordEncoder , students_detailService userDetailsService) throws Exception {
    //     return http.getSharedObject(AuthenticationManagerBuilder.class)
    //             .userDetailsService(userDetailsService)
    //               .passwordEncoder(passwordEncoder)
    //             .and()
    //             .build();
    // }

  
    // @Bean
    // public AuthenticationManager teacher_authenticationManager(HttpSecurity http,PasswordEncoder passwordEncoder , teacher_detailService tscc) throws Exception {
    //     return http.getSharedObject(AuthenticationManagerBuilder.class)
    //             .userDetailsService(tscc)
    //               .passwordEncoder(passwordEncoder)
    //             .and()
    //             .build();
    // }

  
   @Bean
   public AuthenticationProvider studentAuthenticationProvider(){
       DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
       authenticationProvider.setUserDetailsService(userDetailsService);
       authenticationProvider.setPasswordEncoder(passwordEncoder());
       return authenticationProvider;
   }


    
  
    
    @Primary
    @Bean()
    public AuthenticationProvider teacherAuthenticationProvider(){
        DaoAuthenticationProvider tauthenticationProvider=new DaoAuthenticationProvider();
        tauthenticationProvider.setUserDetailsService(tsc);
        tauthenticationProvider.setPasswordEncoder(passwordEncoder());
        return tauthenticationProvider;
    }





  
    @Bean(name ="enf")
    public studentsAuthenticationManager students_AuthenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return new studentsAuthenticationManager(studentAuthenticationProvider());
    }

    @Primary
    @Bean(name="prov")
    public teacherAuthenticationManager teachers_AuthenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return new teacherAuthenticationManager(teacherAuthenticationProvider());
    }










}
