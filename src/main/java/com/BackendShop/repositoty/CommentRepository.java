package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
