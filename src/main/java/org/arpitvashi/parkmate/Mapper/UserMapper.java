package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.UserDTO;
import org.arpitvashi.parkmate.Model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public UserDTO toDTO(UserModel model) {
        UserDTO dto = new UserDTO();
        dto.setUserId(model.getUserId());
        dto.setName(model.getName());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setEmail(model.getEmail());
        dto.setMobileNo(model.getMobileNo());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }


    public static UserModel toEntity(UserDTO dto) {
        UserModel model = new UserModel();
        model.setUserId(dto.getUserId());
        model.setName(dto.getName());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        model.setEmail(dto.getEmail());
        model.setMobileNo(dto.getMobileNo());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }
}
