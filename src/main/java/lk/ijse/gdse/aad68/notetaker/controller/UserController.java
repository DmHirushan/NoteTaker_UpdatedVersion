package lk.ijse.gdse.aad68.notetaker.controller;

import lk.ijse.gdse.aad68.notetaker.dto.NoteDTO;
import lk.ijse.gdse.aad68.notetaker.dto.UserDto;
import lk.ijse.gdse.aad68.notetaker.service.UserService;
import lk.ijse.gdse.aad68.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
        var buildUserDto = new UserDto();
        buildUserDto.setFirstName(firstName);
        buildUserDto.setLastName(lastName);
        buildUserDto.setEmail(email);
        buildUserDto.setPassword(password);
        buildUserDto.setProfilePic(profilePic);

        // send to the service layer
        return new ResponseEntity<>(userService.saveUser(buildUserDto), HttpStatus.CREATED);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable ("userId") String userId){
        return userService.deleteUser(userId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getSelectedUser(@PathVariable ("userId") String userId){
        return userService.getSelectedUser(userId);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

}
