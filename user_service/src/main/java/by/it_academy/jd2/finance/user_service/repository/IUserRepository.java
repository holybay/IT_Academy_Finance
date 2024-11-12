package by.it_academy.jd2.finance.user_service.repository;

import by.it_academy.jd2.finance.user_service.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
}
