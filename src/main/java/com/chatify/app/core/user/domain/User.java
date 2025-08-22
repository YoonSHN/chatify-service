package com.chatify.app.core.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Table(name="user")
@SQLDelete(sql = "UPDATE user SET deleted_at = now() WHERE user_id = ?")
@Where(clause="deleted_at IS NULL")
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", unique=true, length=50)
    private String username;

    @Column(name="password", length=255)
    private String password;

    @Column(name="email", unique = true,length = 100)
    private String email;

    @Column(name="phone_number", unique=true, length=20)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private UserStatus status;

    @Column(name="last_seen_at")
    private LocalDateTime lastSeenAt;

    @Column(name="created_at", nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    @Builder
    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.status = UserStatus.ACTIVE;
    }

}
