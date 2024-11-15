package by.it_academy.jd2.finance.user_service.service.dto;

import by.it_academy.jd2.finance.libs.shared_lib.validation.EnumValidator;
import by.it_academy.jd2.finance.user_service.repository.entity.EUserRole;
import by.it_academy.jd2.finance.user_service.repository.entity.EUserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class UserCreateDto {

    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @NotBlank(message = "Email can't be blank!")
    @Email(message = "Provide your email!")
    private String mail;
    @NotBlank(message = "FIO can't be blank!")
    private String fio;
    @EnumValidator(enumClass = EUserRole.class)
    private String role;
    @EnumValidator(enumClass = EUserStatus.class)
    private String status;
    @NotBlank(message = "Password can't be blank!")
    @Size(min = 8, message = "Min password length is 8 symbols!")
    private String password;

    private UserCreateDto(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String mail, String fio,
                          String role, String status, String password) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateDto that = (UserCreateDto) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(mail, that.mail) && Objects.equals(fio, that.fio) && role == that.role && status == that.status && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, mail, fio, role, status, password);
    }

    @Override
    public String toString() {
        return "UserAdminCreateDto{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}
