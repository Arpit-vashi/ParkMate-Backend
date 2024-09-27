package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDTO createUser(UserDTO user);

    Page<UserDTO> getAllUsers(Pageable pageable);

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDetails);

    void deleteUser(Long id);

    UserDTO getUserByUsername(String username);

    UserDTO getUserByEmail(String email);

    UserDTO getUserByMobileNo(String mobileNo);

    UserDTO getUserByName(String name);

    boolean usernameExists(String username);

    boolean mobileExists(String mobileNo);

    boolean emailExists(String email);
}
