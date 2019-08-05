package net.jogeum.hellojpa.controller;

import com.google.common.collect.ImmutableMap;
import net.jogeum.hellojpa.dto.PostSearchType;
import net.jogeum.hellojpa.service.PostViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/post-view")
public class PostViewController {

    @Autowired
    PostViewService postViewService;

    @GetMapping
    public Map<String, Object> getList(@RequestParam(value = "type", required = false) String type,
                                       @RequestParam(value = "value", required = false) String value) {
        return ImmutableMap.of(
                "result", "success",
                "list", postViewService.getList(
                        type != null ? PostSearchType.valueOf(type) : null,
                        value
                )
        );
    }
}
