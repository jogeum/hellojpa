package net.jogeum.hellojpa.repository;

import net.jogeum.hellojpa.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
