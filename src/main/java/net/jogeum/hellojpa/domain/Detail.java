package net.jogeum.hellojpa.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "post_detail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Post post;

    public Detail(Post post, String description) {
        this.post = post;
        this.description = description;
    }

    public void change(String description) {
        this.description = description;
    }
}
