package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDetails);

    void deleteUser(Long id);

    UserDTO getUserByUsername(String username);

    UserDTO getUserByEmail(String email);

    UserDTO getUserByMobileNo(Long mobileNo);

    UserDTO getUserByName(String name);
}
