package by.it_academy.jd2.finance.user_service.service.validator;

import by.it_academy.jd2.finance.user_service.repository.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserExistValidator implements ConstraintValidator<UserExists, UUID> {

    private final IUserRepository userRepository;

    @Autowired
    public UserExistValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(UUID id, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.existsById(id);
    }
}
