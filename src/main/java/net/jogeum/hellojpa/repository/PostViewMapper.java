package net.jogeum.hellojpa.repository;

import net.jogeum.hellojpa.domain.PostView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PostViewMapper {

    List<PostView> getList(Map<String, ?> params);

    Integer getCount(Map<String, ?> params);
}
