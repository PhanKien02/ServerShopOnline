package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
