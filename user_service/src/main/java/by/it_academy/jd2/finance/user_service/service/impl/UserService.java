package by.it_academy.jd2.finance.user_service.service.impl;

import by.it_academy.jd2.finance.libs.shared_lib.dto.PageOf;
import by.it_academy.jd2.finance.libs.shared_lib.exception.ApplicationException;
import by.it_academy.jd2.finance.user_service.repository.IUserRepository;
import by.it_academy.jd2.finance.user_service.repository.entity.User;
import by.it_academy.jd2.finance.user_service.service.IUserService;
import by.it_academy.jd2.finance.user_service.service.dto.PageDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserCreateDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserOutDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserUpdateDto;
import by.it_academy.jd2.finance.user_service.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void create(UserCreateDto createDto) {
        createDto.setId(UUID.randomUUID());
        createDto.setCreatedAt(LocalDateTime.now());
        createDto.setUpdatedAt(createDto.getCreatedAt());
        userRepository.saveAndFlush(userMapper.toEntity(createDto));
    }

    @Override
    public UserOutDto getById(UUID id) {
        return userRepository.findById(id)
                             .map(userMapper::toUserOutDto)
                             .orElseThrow(() -> new ApplicationException("Haven't found a user with id: " + id));
    }

    @Override
    public PageOf<UserOutDto> getAll(PageDto pageDto) {
        Sort.TypedSort<User> user = Sort.sort(User.class);
        Sort sort = user.by(User::getCreatedAt).descending().and(user.by(User::getFio).ascending());
        PageRequest pageReq = PageRequest.of(pageDto.getPage(), pageDto.getSize(), sort);
        Page<UserOutDto> userPage = userRepository.findAll(pageReq)
                                                  .map(userMapper::toUserOutDto);
        return PageOf.convert(userPage);
    }

    @Override
    public void update(UserUpdateDto updateDto) {
        User entity = userMapper.toEntity(updateDto);
        userRepository.saveAndFlush(entity);
    }
}
