package eu.freakydirac.restfulspring;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RestfulSpringRestController {

    @Autowired
    ExampleService exampleService;


    @RequestMapping("/user/{firstname}/{lastname}")
    public User user(Principal principal,@PathVariable String firstname,@PathVariable String lastname) {

        return exampleService.getUser(firstname,lastname);
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public void login(@RequestBody LoginRequestBody body){

        AuthenticationManager am = new SampleAuthenticationManager();
        System.out.println("--- login webservice ---");
        System.out.println("username: " + body.getUsername());
        System.out.println("passoword: " + body.getPassword());
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
            Authentication result = am.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            System.out.println("AUTHENTICATED!!!!");
        } catch(AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }


    }

    class SampleAuthenticationManager implements AuthenticationManager {
         List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
         public SampleAuthenticationManager() {
             AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
         }

        public Authentication authenticate(Authentication auth) throws AuthenticationException {
            if (auth.getName().equals(auth.getCredentials()))
                return new UsernamePasswordAuthenticationToken(auth.getName(),
                        auth.getCredentials(), AUTHORITIES);
            throw new BadCredentialsException("Bad Credentials");
        }
    }

    @RequestMapping(value="/logout")
    public void logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)  new SecurityContextLogoutHandler().logout(request, response, auth);

    }

}











