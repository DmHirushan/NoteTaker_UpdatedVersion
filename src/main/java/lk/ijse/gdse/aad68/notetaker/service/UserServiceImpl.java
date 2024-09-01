package lk.ijse.gdse.aad68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad68.notetaker.dto.NoteDTO;
import lk.ijse.gdse.aad68.notetaker.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public String saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public boolean updateUser(String userId, UserDto userDto) {
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public NoteDTO getSelectedUser(String userId) {
        return null;
    }

    @Override
    public List<NoteDTO> getAllUsers() {
        return null;
    }
}
