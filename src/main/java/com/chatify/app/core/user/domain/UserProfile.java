package com.chatify.app.core.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name="user_profile")
@Getter
public class UserProfile {

    @Id
    @Column(name="user_id")
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="real_name", length=50)
    private String realName;

    @Column(name="birthday")
    private LocalDate birthday;

    @Column(name="profile_message", length=255)
    private String profileMessage;

    @Column(name="nickname", length=50, unique=true)
    private String nickname;

    @CreationTimestamp
    @Column(name="created_at", nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at", nullable=false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

}
