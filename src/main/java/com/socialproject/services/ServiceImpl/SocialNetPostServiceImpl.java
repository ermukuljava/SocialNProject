package com.socialproject.services.ServiceImpl;

import com.socialproject.entities.SocialNetworkPost;
import com.socialproject.exceptions.SocialPostNotFound;
import com.socialproject.repositories.SocialNetworkPostRepo;
import com.socialproject.services.SocialNetPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialNetPostServiceImpl implements SocialNetPostService {

    @Autowired
    private SocialNetworkPostRepo socialNetworkPostRepo;

    @Override
    public List<SocialNetworkPost> getTop10PostByCategory(String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<SocialNetworkPost> socialNetworkPostsList = socialNetworkPostRepo.findTop10ByPostCategoryOrderByViewCountDesc(category, pageable);
        if(socialNetworkPostsList==null){
            throw new SocialPostNotFound("Social post not found"+category);
        }
        return socialNetworkPostsList;
    }

    @Override
    public List<SocialNetworkPost> getSocialPostByAutherName(String name) {

        List<SocialNetworkPost> socialNetworkPostsList = socialNetworkPostRepo.findByAuther(name);
        if (socialNetworkPostsList==null){
            throw new SocialPostNotFound("No Social Post found for Auther"+name);
        }
        return socialNetworkPostsList;
    }
}
