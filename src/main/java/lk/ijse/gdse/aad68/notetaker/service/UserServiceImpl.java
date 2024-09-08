package lk.ijse.gdse.aad68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad68.notetaker.dao.UserDao;
import lk.ijse.gdse.aad68.notetaker.dto.NoteDTO;
import lk.ijse.gdse.aad68.notetaker.dto.UserDto;
import lk.ijse.gdse.aad68.notetaker.entity.UserEntity;
import lk.ijse.gdse.aad68.notetaker.exception.UserNotFoundException;
import lk.ijse.gdse.aad68.notetaker.util.AppUtil;
import lk.ijse.gdse.aad68.notetaker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private final Mapping mapping;
    @Override
    public String saveUser(UserDto userDto) {
        userDto.setUserId(AppUtil.createUserId());
        UserEntity savedUser = userDao.save(mapping.convertToEntity(userDto));
        if (savedUser != null && savedUser.getUserId() != null){
            return "User saved successfully!";
        }else {
            return "Save Failed!";
        }
    }

    @Override
    public void updateUser(UserDto userDto) {
        Optional<UserEntity> tmpUser = userDao.findById(userDto.getUserId());
        if (!tmpUser.isPresent()){
            throw new UserNotFoundException("User Not Found!");
        }else {
            tmpUser.get().setFirstName(userDto.getFirstName());
            tmpUser.get().setEmail(userDto.getEmail());
            tmpUser.get().setLastName(userDto.getLastName());
            tmpUser.get().setPassword(userDto.getPassword());
            tmpUser.get().setProfilePic(userDto.getProfilePic());
        }
    }

    @Override
    public boolean deleteUser(String userId) {
        if (userDao.existsById(userId)){
            userDao.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public UserDto getSelectedUser(String userId) {
        return mapping.convertToUserDTO(userDao.getUserEntityByUserId(userId));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return mapping.convertToUserDTOS(userDao.findAll());
    }
}
