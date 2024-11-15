package by.it_academy.jd2.finance.user_service.service.mapper;

import by.it_academy.jd2.finance.user_service.repository.entity.EUserRole;
import by.it_academy.jd2.finance.user_service.repository.entity.EUserStatus;
import by.it_academy.jd2.finance.user_service.repository.entity.User;
import by.it_academy.jd2.finance.user_service.service.dto.UserCreateDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserOutDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserUpdateDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserCreateDto createDto) {
        return User.builder()
                   .setId(createDto.getId())
                   .setCreatedAt(createDto.getCreatedAt())
                   .setUpdatedAt(createDto.getUpdatedAt())
                   .setMail(createDto.getMail())
                   .setFio(createDto.getFio())
                   .setRole(Enum.valueOf(EUserRole.class, createDto.getRole()))
                   .setStatus(Enum.valueOf(EUserStatus.class, createDto.getStatus()))
                   .setPassword(createDto.getPassword())
                   .build();
    }

    public User toEntity(UserUpdateDto updateDto) {
        return User.builder()
                   .setId(updateDto.getId())
                   .setUpdatedAt(updateDto.getUpdatedAt())
                   .setMail(updateDto.getMail())
                   .setFio(updateDto.getFio())
                   .setRole(Enum.valueOf(EUserRole.class, updateDto.getRole()))
                   .setStatus(Enum.valueOf(EUserStatus.class, updateDto.getStatus()))
                   .setPassword(updateDto.getPassword())
                   .build();
    }

    public UserOutDto toUserOutDto(User entity) {
        return UserOutDto.builder()
                         .setId(entity.getId())
                         .setCreatedAt(entity.getCreatedAt())
                         .setUpdatedAt(entity.getUpdatedAt())
                         .setMail(entity.getMail())
                         .setFio(entity.getFio())
                         .setRole(entity.getRole())
                         .setStatus(entity.getStatus())
                         .build();
    }
}
