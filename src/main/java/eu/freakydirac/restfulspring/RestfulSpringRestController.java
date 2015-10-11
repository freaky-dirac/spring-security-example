package eu.freakydirac.restfulspring;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestfulSpringRestController {


    @RequestMapping("/user/{firstname}/{lastname}")
    @Secured("ROLE_ADMIN")
    public User user(@PathVariable String firstname,@PathVariable String lastname) {

        User user = new User(firstname, lastname);
        return user;
    }

}