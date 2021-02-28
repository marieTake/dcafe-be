package com.dcafe.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
