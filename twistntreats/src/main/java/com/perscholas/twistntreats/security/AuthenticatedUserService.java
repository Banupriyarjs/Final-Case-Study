package com.perscholas.twistntreats.security;
import com.perscholas.twistntreats.database.dao.UserDAO;
import com.perscholas.twistntreats.database.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String getCurrentUsername() {
        // this function will return the username of the currently logged in user
        // or it will return null if no user is logged in
        // in our case the username is the email
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null && context.getAuthentication() != null) {
            final org.springframework.security.core.userdetails.User principal =
                    (org.springframework.security.core.userdetails.User) context.getAuthentication().getPrincipal();
            return principal.getUsername();
        } else {
            // there is no spring security context for this user so they are not logged in
            return null;
        }
    }

    public User loadCurrentUser() {
        User user = userDao.findByEmailIgnoreCase(getCurrentUsername());
        return user;
    }

    public void authenticateNewUser(HttpSession session, String username, String unencryptedPassword) {
        // this function is called in the create user process to authenticate a brand new user
        Authentication request = new UsernamePasswordAuthenticationToken(username, unencryptedPassword);
        Authentication result = authenticationManager.authenticate(request);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(result);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
    }


}