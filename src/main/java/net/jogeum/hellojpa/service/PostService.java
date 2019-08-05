package net.jogeum.hellojpa.service;

import com.google.common.collect.ImmutableList;
import net.jogeum.hellojpa.domain.Category;
import net.jogeum.hellojpa.domain.Post;
import net.jogeum.hellojpa.domain.Reply;
import net.jogeum.hellojpa.domain.Tag;
import net.jogeum.hellojpa.dto.PostDTO;
import net.jogeum.hellojpa.dto.PostSearchType;
import net.jogeum.hellojpa.repository.CategoryRepository;
import net.jogeum.hellojpa.repository.PostRepository;
import net.jogeum.hellojpa.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TagRepository tagRepository;


    @Transactional(rollbackFor = Exception.class)
    public List<PostDTO> getList(PostSearchType type, String value) {

        List<Post> postList = null;

        if (type != null && !StringUtils.isEmpty(value)) {
            switch (type) {
                case title:
                    postList = postRepository.findAllByTitleLike("%" + value + "%");
                    break;

                case category:
                    Optional<Category> optionalCategory = categoryRepository.findByName(value);
                    if (optionalCategory.isPresent()) {
                        postList = postRepository.findAllByCategory(optionalCategory.get());
                    }
                    break;

                case date:
                    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                    LocalDateTime date = LocalDate.parse(value, formatter).atStartOfDay();
                    postList = postRepository.findAllByCreatedDateGreaterThanEqualOrderByIdDesc(date);
                    break;

                case tag:
                    Optional<Tag> optionalTag = tagRepository.findById(value);
                    if (optionalTag.isPresent()) {
                        postList = postRepository.findAllByTagListInOrderByCreatedDateAsc(ImmutableList.of(optionalTag.get()));
                    }
                    break;
            }
        }

        if (postList == null) {
            postList = postRepository.findAll();
        }

        return postList.stream().map(this::dto).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public PostDTO get(long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (!optionalPost.isPresent()) {
            throw new RuntimeException("Post id: " + id + " 값을 찾을 수 없습니다.");
        }

        return this.dto(optionalPost.get());
    }

    private PostDTO dto(Post post) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCategory().getId(),
                post.getDescription(),
                post.getReplyList().stream().map(Reply::getReply).collect(Collectors.toList()),
                post.getTagList().stream().map(Tag::getName).collect(Collectors.toList()),
                post.getCreatedBy(),
                post.getCreatedDate().format(formatter)
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(PostDTO dto) {

        Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategory_id());
        if (!optionalCategory.isPresent()) {
            throw new RuntimeException("Category id: " + dto.getCategory_id() + " 값을 찾을 수 없습니다.");
        }

        Post post = new Post(
                optionalCategory.get(),
                dto.getTitle(),
                dto.getContent(),
                dto.getDescription(),
                this.getTagList(dto.getTagList()),
                dto.getCreatedBy()
        );

        postRepository.save(post);
    }

    @Transactional(rollbackFor = Exception.class)
    public void change(PostDTO dto) {
        Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategory_id());
        if (!optionalCategory.isPresent()) {
            throw new RuntimeException("Category id: " + dto.getCategory_id() + " 값을 찾을 수 없습니다.");
        }

        Optional<Post> optionalPost = postRepository.findById(dto.getId());
        if (!optionalPost.isPresent()) {
            throw new RuntimeException("Post id: " + dto.getId() + " 값을 찾을 수 없습니다.");
        }

        Post post = optionalPost.get();
        post.change(
                optionalCategory.get(),
                dto.getTitle(),
                dto.getContent(),
                dto.getDescription(),
                this.getTagList(dto.getTagList())
        );

        postRepository.save(post);
    }

    private List<Tag> getTagList(List<String> tagList) {

        if (CollectionUtils.isEmpty(tagList)) {
            return new ArrayList<>();
        }

        return tagList.stream().map(n -> {
            Optional<Tag> optionalTag = tagRepository.findById(n);
            if (!optionalTag.isPresent()) {
                throw new RuntimeException("Tag: " + n + " 값을 찾을 수 없습니다.");
            }
            return optionalTag.get();
        }).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(long id) {
        postRepository.deleteById(id);
    }
}
