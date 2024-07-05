package com.socialproject.controllers;

import com.socialproject.entities.SocialNetworkPost;
import com.socialproject.services.SocialNetPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SocialNetPostController {

    @Autowired
    private SocialNetPostService socialNetPostService;

    @GetMapping("/countpost")
    public List<SocialNetworkPost> getTopPostByCategory(@RequestParam String category, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int size){
        return socialNetPostService.getTop10PostByCategory(category, page, size);
    }

    @GetMapping("/countpostbyauth")
    public List<SocialNetworkPost> getSocialPostByAuther(String name){
        return socialNetPostService.getSocialPostByAutherName(name);
    }
}
