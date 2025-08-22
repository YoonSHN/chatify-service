package com.chatify.app.core.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="user_settings")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserSettings {

    @Id
    @Column(name="user_id")
    private Long id;

    @OneToOne(fetch= FetchType.LAZY)
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="locale", length=10, nullable=false)
    private String locale = "ko-KR";

    @Column(name="timezone", length=40, nullable=false)
    private String timeZone = "Asia/Seoul";

    @Column(name="push_enable", nullable=false)
    private boolean pushEnable = true;

    @Column(name="marketing_opt_in", nullable=false)
    private boolean marketingOptIn = false;

    @Column(name="last_seen_visible", nullable = false)
    private boolean lastSeenVisible = true;

    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at",  nullable=false)
    private LocalDateTime updatedAt;
}
