package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static org.example.GeneratorId.getGeneratorId;

public class PostRepository {

    private final ConcurrentHashMap<Long, Post> posts = new ConcurrentHashMap<>();

    public List<Post> all() {
        return new ArrayList<>(posts.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(posts.get(id));
    }

    public Post save(Post post) throws NotFoundException {
        if (post.getId() == 0) {
            post.setId(getGeneratorId().getId());
        } else if (!posts.containsKey(post.getId())) {
            throw new NotFoundException();
        }
        posts.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) throws NotFoundException {
        if (posts.containsKey(id)) {
            posts.remove(id);
        } else {
            throw new NotFoundException();
        }
    }
}