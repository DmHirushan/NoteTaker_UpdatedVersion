package lk.ijse.gdse.aad68.notetaker.service;

import lk.ijse.gdse.aad68.notetaker.dto.NoteDTO;
import lk.ijse.gdse.aad68.notetaker.dto.UserDto;

import java.util.List;

public interface UserService {
    String saveUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    boolean deleteUser(String userId);
    UserDto getSelectedUser(String userId);
    List<UserDto> getAllUsers();
}
