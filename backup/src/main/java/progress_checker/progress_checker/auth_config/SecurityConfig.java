package progress_checker.progress_checker.auth_config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
    private UserDetailsServiceImpl userDetailsService;

    



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
                      .requestMatchers("/auth/**","/addStudent","/addTeacher","/send_otp","/verify_otp","/new_grade","/addsubject").permitAll()
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
    

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,PasswordEncoder passwordEncoder , UserDetailsServiceImpl userDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                  .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }
}
