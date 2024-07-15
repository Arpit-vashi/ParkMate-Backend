package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.usersDto;

import java.util.List;

public interface usersService {

    usersDto createUser(usersDto user);

    List<usersDto> getAllUsers();

    usersDto getUserById(Long id);

    usersDto updateUser(Long id, usersDto userDetails);

    void deleteUser(Long id);

    usersDto getUserByUsername(String username);

    usersDto getUserByEmail(String email);

    usersDto getUserByMobileNo(Long mobileno);
}
