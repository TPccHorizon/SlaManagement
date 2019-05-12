package ch.uzh.slamer.backend.controller;


import ch.uzh.slamer.backend.exception.SlaUserNotFoundException;
import ch.uzh.slamer.backend.model.pojo.LoginData;
import ch.uzh.slamer.backend.repository.JooqSlaUserRepository;
import ch.uzh.slamer.backend.service.AuthenticationService;
import codegen.tables.pojos.SlaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class AuthenticationController {

    @Autowired
    private JooqSlaUserRepository repository;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<SlaUser> register(@RequestBody SlaUser slaUser) {
        SlaUser user = authenticationService.registerNewUser(slaUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<SlaUser> login(@RequestBody LoginData loginData) {
        System.out.println("A User tries to log in.");
        SlaUser existingUser;
        try {
            existingUser = repository.findByUsername(loginData.getUserName());
        } catch (SlaUserNotFoundException e) {
            System.out.println("No user found with username: " + loginData.getUserName());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        System.out.println("Found User with matching username. Now verify PW");
        boolean isValid = authenticationService.checkUserCredentials(loginData.getPassword(), existingUser);
        if (isValid) {
            System.out.println("Access Granted");
            return ResponseEntity.ok(existingUser);
        } else {
            System.out.println("Access Denied. Wrong username or password");
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}
