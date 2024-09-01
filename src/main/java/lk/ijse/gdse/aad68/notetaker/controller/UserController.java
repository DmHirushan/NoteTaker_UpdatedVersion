package lk.ijse.gdse.aad68.notetaker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/healthcheck")
    public String healthCheck(){
        return "User Controller running!";
    }
}
