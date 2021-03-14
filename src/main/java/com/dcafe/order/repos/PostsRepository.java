package com.dcafe.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

}
