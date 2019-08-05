package net.jogeum.hellojpa.controller;

import com.google.common.collect.ImmutableMap;
import net.jogeum.hellojpa.dto.PostDTO;
import net.jogeum.hellojpa.dto.PostSearchType;
import net.jogeum.hellojpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public Map<String, Object> getList(@RequestParam(value = "type", required = false) String type,
                                       @RequestParam(value = "value", required = false) String value) {
        return ImmutableMap.of(
                "result", "success",
                "list", postService.getList(
                        type != null ? PostSearchType.valueOf(type) : null,
                        value
                )
        );
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable("id") long id) {
        return ImmutableMap.of(
                "result", "success",
                "post", postService.get(id)
        );
    }

    @PostMapping
    public Map<String, Object> save(PostDTO dto) {
        postService.save(dto);

        return ImmutableMap.of(
                "result", "success"
        );
    }

    @PutMapping
    public Map<String, Object> change(PostDTO dto) {
        postService.change(dto);

        return ImmutableMap.of(
                "result", "success"
        );
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") long id) {
        postService.delete(id);

        return ImmutableMap.of(
                "result", "success"
        );
    }
}
