package org.training.l301.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.training.l301.entities.Account;
import org.training.l301.repository.AccountRepository;
import org.training.l301.repository.EmployeeRepository;


@RestController
public class TestController {

    private final AccountRepository accountRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public TestController(AccountRepository accountRepository, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @GetMapping("/test2")
    public String test2() {
        employeeRepository.findAll().forEach(System.out::println);
        return "Hello World";
    }

    @GetMapping("/login")
    public String login() {
        return "Login Page";
    }

    @GetMapping("/")
    public String home() {
        return "Home Page";
    }

    @GetMapping("/register")
    public String register() {
        return "Register Page";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Account account) {
        Account savedAccount = null;
        ResponseEntity response = null;
        try {
            savedAccount = accountRepository.save(account);
            if (savedAccount.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }
}
