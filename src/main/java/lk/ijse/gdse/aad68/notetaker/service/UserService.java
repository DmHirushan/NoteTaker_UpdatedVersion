package lk.ijse.gdse.aad68.notetaker.service;

import lk.ijse.gdse.aad68.notetaker.customObj.UserResponse;
import lk.ijse.gdse.aad68.notetaker.dto.impl.UserDto;

import java.util.List;

public interface UserService {
    String saveUser(UserDto userDto);
    void updateUser(UserDto userDto);
    boolean deleteUser(String userId);
    UserResponse getSelectedUser(String userId);
    List<UserDto> getAllUsers();
}
