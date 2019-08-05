package net.jogeum.hellojpa.repository;

import net.jogeum.hellojpa.domain.Category;
import net.jogeum.hellojpa.domain.Post;
import net.jogeum.hellojpa.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByTitleLike(String title);

    List<Post> findAllByCategory(Category category);

    List<Post> findAllByCreatedDateGreaterThanEqualOrderByIdDesc(LocalDateTime localDateTime);

    List<Post> findAllByTagListInOrderByCreatedDateAsc(List<Tag> tagList);
}
