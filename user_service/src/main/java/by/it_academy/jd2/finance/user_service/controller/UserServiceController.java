package by.it_academy.jd2.finance.user_service.controller;

import by.it_academy.jd2.finance.libs.shared_lib.dto.PageOf;
import by.it_academy.jd2.finance.libs.shared_lib.util.DateUtil;
import by.it_academy.jd2.finance.user_service.service.IUserService;
import by.it_academy.jd2.finance.user_service.service.dto.PageDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserCreateDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserOutDto;
import by.it_academy.jd2.finance.user_service.service.dto.UserUpdateDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserServiceController {

    public static final String PATH_VAR_ID_NAME = "uuid";
    public static final String PATH_VAR_DT_UPDATE = "dt_update";
    private final IUserService userService;

    @Autowired
    public UserServiceController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody UserCreateDto createDto) {
        userService.create(createDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserOutDto> getById(@PathVariable(PATH_VAR_ID_NAME) UUID id) {
        UserOutDto user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageOf<UserOutDto>> getAll(
            @RequestParam(required = false, defaultValue = "0") @Valid @PositiveOrZero(message =
                    "Page value must be greater than zero!") int page,
            @RequestParam(required = false, defaultValue = "20") @Valid @Positive(message =
                    "Page size must not be negative or zero!") int size) {
        PageOf<UserOutDto> users = userService.getAll(PageDto.builder()
                                                             .setPage(page)
                                                             .setSize(size)
                                                             .build());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<HttpStatus> update(@PathVariable(PATH_VAR_ID_NAME) UUID id,
                                             @PathVariable(PATH_VAR_DT_UPDATE) long updatedAt,
                                             @RequestBody UserUpdateDto updateDto) {
        updateDto.setId(id);
        updateDto.setUpdatedAt(DateUtil.longToLocalDateTime(updatedAt));
        userService.update(updateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
