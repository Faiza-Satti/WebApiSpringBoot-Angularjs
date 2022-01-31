package com.example.demo;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    @PostConstruct
//    public void seedUser() {
//        if (userRepository.findByUsername("Faiza") == null) {
//            String encodedPassword = passwordEncoder.encode("12345");
//            ApplicationUser user = new ApplicationUser(1, "Faiza", encodedPassword,"Administrator");
//            userRepository.save(user);
//        }
//    }
//
}
