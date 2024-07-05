package com.socialproject.repositories;

import com.socialproject.entities.SocialNetworkPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialNetworkPostRepo extends JpaRepository<SocialNetworkPost, Long> {

    List<SocialNetworkPost> findTop10ByPostCategoryOrderByViewCountDesc(String postCategory, Pageable pageable);
    List<SocialNetworkPost> findByAuther(String name);
}
