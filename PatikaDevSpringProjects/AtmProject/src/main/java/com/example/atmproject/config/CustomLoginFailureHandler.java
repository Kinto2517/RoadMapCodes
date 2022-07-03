package com.example.atmproject.config;

import com.example.atmproject.model.User;
import com.example.atmproject.repository.UserRepository;
import com.example.atmproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String email = request.getParameter("email");
        User user = userService.getByEmail(email);

        if (user != null) {
                if(user.isAccountNonLocked()){
                    if(user.getFailed_attempt() < 2){
                        user.setFailed_attempt(user.getFailed_attempt() + 1);
                        userService.save(user);
                        userRepository.updateFailedAttempt(user.getFailed_attempt(), user.getEmail());
                    }else {
                        user.setAccount_non_locked(false);
                        user.setLock_time(new Date());

                        userRepository.save(user);
                        try {
                            throw new FailedLoginException("Account is locked");
                        } catch (FailedLoginException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

        }

        super.setDefaultFailureUrl("/login?error");
        super.onAuthenticationFailure(request, response, exception);
    }
}
