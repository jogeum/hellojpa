package net.jogeum.hellojpa.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Detail detail;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Reply> replyList;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_name")
    )
    private List<Tag> tagList;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    public Post(Category category, String title, String content, String description, List<Tag> tagList, String createdBy) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.detail = new Detail(this, description);
        this.tagList = tagList;
        this.replyList = new ArrayList<>();
        this.createdBy = createdBy;
        this.createdDate = LocalDateTime.now();
    }

    public void addReply(String reply) {
        this.replyList.add(new Reply(this, reply));
    }

    public void change(Category category, String title, String content, String description, List<Tag> tagList) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.detail.change(description);
        this.tagList = tagList;
    }

    public String getDescription() {
        if (this.detail != null) {
            return this.detail.getDescription();
        } else {
            return "";
        }
    }
}
