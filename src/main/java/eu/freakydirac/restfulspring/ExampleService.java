package eu.freakydirac.restfulspring;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;



@Component
public class ExampleService {

    @Secured({"ROLE_USER"})
    public User getUser(String firstname, String lastname){
        User user = new User("service:" + firstname, "service:" + lastname);
        return user;
    }
}
