package lk.ijse.gdse.aad68.notetaker.controller;

import lk.ijse.gdse.aad68.notetaker.dto.UserDto;
import lk.ijse.gdse.aad68.notetaker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/healthcheck")
    public String healthCheck(){
        return "User Controller running!";
    }

    @GetMapping
    public String saveUser(UserDto userDto){
        return null;
    }

}
