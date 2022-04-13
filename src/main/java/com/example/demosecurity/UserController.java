package com.example.demosecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private List<Greeting> greetings;

    public UserController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.greetings = new ArrayList<>(Arrays.asList(
                new Greeting("Hej"),
                new Greeting("Aloha"),
                new Greeting("Yo")
        ));
        List<String> strings = Arrays.asList("f", "y");
    }

    @GetMapping("/{username}")
    public ResponseEntity<ApplicationUser> getUserByUsername(@PathVariable String username) {
        ApplicationUser user = applicationUserRepository.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/record")
    public ResponseEntity<ApplicationUser> signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        ApplicationUser user1 = applicationUserRepository.save(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/greet")
    public List<Greeting> greet() {
        return greetings;
    }
}
