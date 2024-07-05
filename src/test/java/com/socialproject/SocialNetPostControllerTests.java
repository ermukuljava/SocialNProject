package com.socialproject;

import com.socialproject.entities.SocialNetworkPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SocialNetPostControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getTopPostByCategory(){
        ResponseEntity<SocialNetworkPost[]> response = restTemplate.getForEntity("/api/v1/countpost?category=music", SocialNetworkPost[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    void getSocialPostByAutherName(){
        ResponseEntity<SocialNetworkPost[]> response = restTemplate.getForEntity("/api/v1/countpostbyauth", SocialNetworkPost[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();

    }
}
