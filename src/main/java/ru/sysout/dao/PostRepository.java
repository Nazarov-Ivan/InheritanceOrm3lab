package ru.sysout.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sysout.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}