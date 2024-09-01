package lk.ijse.gdse.aad68.notetaker.controller;

import lk.ijse.gdse.aad68.notetaker.dto.UserDto;
import lk.ijse.gdse.aad68.notetaker.service.UserService;
import lk.ijse.gdse.aad68.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveUser(@RequestPart("firstName") String firstName,
                                           @RequestPart("lastName") String lastName,
                                           @RequestPart("email") String email,
                                           @RequestPart("password") String password,
                                           @RequestPart("profilePic") String profilePic){
        //Handle profile pic
        var base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
        var buildUserDto = new UserDto();
        buildUserDto.setFirstName(firstName);
        buildUserDto.setLastName(lastName);
        buildUserDto.setEmail(email);
        buildUserDto.setPassword(password);
        buildUserDto.setProfilePic(profilePic);

        // send to the service layer
        userService.saveUser(buildUserDto);
        return null;
    }

}
