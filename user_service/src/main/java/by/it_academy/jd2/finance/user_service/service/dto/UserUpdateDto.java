package by.it_academy.jd2.finance.user_service.service.dto;

import by.it_academy.jd2.finance.user_service.repository.entity.EUserRole;
import by.it_academy.jd2.finance.user_service.repository.entity.EUserStatus;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class UserUpdateDto {

    private UUID id;
    private LocalDateTime updatedAt;
    private String mail;
    private String fio;
    private String role;
    private String status;
    private String password;

    private UserUpdateDto(UUID id, LocalDateTime updatedAt, String mail, String fio, String role,
                          String status, String password) {
        this.id = id;
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
        UserUpdateDto that = (UserUpdateDto) o;
        return Objects.equals(id, that.id) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(mail, that.mail) && Objects.equals(fio, that.fio) && role == that.role && status == that.status && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, updatedAt, mail, fio, role, status, password);
    }

    @Override
    public String toString() {
        return "UserUpdateDto{" +
                "id=" + id +
                ", updatedAt=" + updatedAt +
                ", mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}
