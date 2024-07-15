package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.usersDto;
import org.arpitvashi.parkmate.Model.usersModel;

import java.util.List;
import java.util.stream.Collectors;

public class usersMapper {

    // Convert usersModel to usersDto
    public static usersDto toDto(usersModel user) {
        return new usersDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getMobileNo(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

    // Convert List<usersModel> to List<usersDto>
    public static List<usersDto> toDtoList(List<usersModel> users) {
        return users.stream()
                .map(usersMapper::toDto)
                .collect(Collectors.toList());
    }

    // Convert usersDto to usersModel
    public static usersModel toEntity(usersDto userDto) {
        return new usersModel(
                userDto.getUserId(),
                userDto.getUsername(),
                null, // You might not need to map passwordHash here
                userDto.getEmail(),
                userDto.getRole(),
                userDto.getCreatedAt()
        );
    }
}
