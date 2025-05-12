package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.repository.GreetingRepository;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping
    public String getGreeting() {
        return "Hello World - GET";
    }

    @PostMapping
    public String postGreeting() {
        return "Hello World - POST";
    }

    @PutMapping
    public String putGreeting() {
        return "Hello World - PUT";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "Hello World - DELETE";
    }

    @GetMapping("/service")
    public String getServiceGreeting() {
        return greetingService.getGreeting();
    }

    @PostMapping("/custom")
    public String getCustomGreeting(@RequestBody User user) {
        if (user.getFirstName() != null && user.getLastName() != null)
            return "Hello " + user.getFirstName() + " " + user.getLastName();
        else if (user.getFirstName() != null)
            return "Hello " + user.getFirstName();
        else if (user.getLastName() != null)
            return "Hello " + user.getLastName();
        else
            return "Hello World";
    }

    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreeting(@PathVariable Long id) {
        return greetingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(updatedGreeting.getMessage());
            return ResponseEntity.ok(greetingRepository.save(greeting));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}