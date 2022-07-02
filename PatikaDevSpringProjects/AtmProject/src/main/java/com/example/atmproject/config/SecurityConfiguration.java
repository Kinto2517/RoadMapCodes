//package com.example.atmproject.config;
//
//import com.example.atmproject.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    private UserService userService;
//
//    AuthenticationManager authenticationManager;
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler successHandler() {
//        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
//        handler.setUseReferer(true);
//        return handler;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.authenticationProvider(authProvider());
//        authenticationManager = authenticationManagerBuilder.build();
//
//
//        http.csrf().disable().cors().disable().authorizeHttpRequests().antMatchers("/").hasAuthority("USER")
//                .antMatchers(
//                        "/register**",
//                        "/js**",
//                        "/css**",
//                        "/img**",
//                        "/fonts**"
//                ).permitAll().anyRequest().authenticated()                .and()
//                .formLogin().loginPage("/login").successHandler(successHandler()).permitAll().and().logout()
//                .invalidateHttpSession(true).clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout").permitAll()
//                .and()
//                .authenticationManager(authenticationManager)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        ;
//
//        return http.build();
//    }
//
//
//}
//
//
//
