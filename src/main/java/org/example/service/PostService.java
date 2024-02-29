package org.example.service;


import org.example.repository.PostRepository;
import org.example.exception.NotFoundException;
import org.example.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;


public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return new CopyOnWriteArrayList<>(repository.getPosts().values());
    }

    public Optional<Post> getById(long id) throws NotFoundException {
        return repository.getById(id);
//    return repository.getById(id).orElseThrow(NotFoundPostException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public Optional<Post> removeById(long id) {
        return repository.removeById(id);
//    return repository.removeById(id).orElseThrow(NotFoundPostException::new);
    }
}