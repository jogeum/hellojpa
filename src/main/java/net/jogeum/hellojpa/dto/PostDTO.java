package net.jogeum.hellojpa.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostDTO {
    private long id;
    private String title;
    private String content;
    private long category_id;
    private String description;

    private List<String> replyList;
    private List<String> tagList;

    private String createdBy;
    private String createdDate;
}
