package net.jogeum.hellojpa.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostViewDTO {
    private Long id;
    private String categoryName;
    private String title;
    private String content;
    private String description;
    private String tag;
    private String createdBy;
    private String createdDate;
}
