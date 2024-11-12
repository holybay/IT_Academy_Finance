package by.it_academy.jd2.finance.user_service.service;

import by.it_academy.jd2.finance.libs.shared_lib.dto.PageDto;
import by.it_academy.jd2.finance.libs.shared_lib.dto.PageOf;
import by.it_academy.jd2.finance.user_service.service.dto.UserCreateDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserOutDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserUpdateDto;

import java.util.UUID;

public interface IUserService {

    void create(UserCreateDto createDto);

    UserOutDto getById(UUID id);

    PageOf<UserOutDto> getAll(PageDto pageDto);

    void update(UserUpdateDto updateDto);
}
