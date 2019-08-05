package net.jogeum.hellojpa.service;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import net.jogeum.hellojpa.domain.PostView;
import net.jogeum.hellojpa.dto.PostSearchType;
import net.jogeum.hellojpa.dto.PostViewDTO;
import net.jogeum.hellojpa.repository.PostViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostViewService {
    @Autowired
    PostViewMapper postViewMapper;

    @Transactional(rollbackFor = Exception.class)
    public List<PostViewDTO> getList(PostSearchType type, String value) {

        Map<String, Object> params = new HashMap<>();

        if (!StringUtils.isEmpty(type) && !StringUtils.isEmpty(value)) {
            params.put("type", type);
            params.put("value", value);
        }

        return postViewMapper
                .getList(params).stream()
                .map(this::dto)
                .collect(Collectors.toList());
    }

    private PostViewDTO dto(PostView post) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return new PostViewDTO(
                post.getId(),
                post.getCategoryName(),
                post.getTitle(),
                post.getContent(),
                post.getDescription(),
                post.getTag(),
                post.getCreatedBy(),
                post.getCreatedDate().format(formatter)
        );
    }
}
