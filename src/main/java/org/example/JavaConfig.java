package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.controller_service_repository.PostController;
import org.example.controller_service_repository.PostRepository;
import org.example.controller_service_repository.PostService;


@Configuration
public class JavaConfig {
    // аргумент метода и есть DI
    // название метода - название бина

    @Bean
    public PostController postController(PostService service) {
        return new PostController(service);
    }

    @Bean
    public PostService postService(PostRepository repository) {
        return new PostService(repository);
    }

    @Bean
    public PostRepository postRepository() {
        return PostRepository.get();
    }
}