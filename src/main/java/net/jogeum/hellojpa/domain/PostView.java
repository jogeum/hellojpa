package net.jogeum.hellojpa.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostView {
    private Long id;
    private String categoryName;
    private String title;
    private String content;
    private String description;
    private String tag;
    private String createdBy;
    private LocalDateTime createdDate;
}
