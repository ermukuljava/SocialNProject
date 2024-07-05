package com.socialproject.services;

import com.socialproject.entities.SocialNetworkPost;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SocialNetPostService {

    public List<SocialNetworkPost> getTop10PostByCategory(String category, int page, int size);
    public List<SocialNetworkPost> getSocialPostByAutherName(String name);

}
