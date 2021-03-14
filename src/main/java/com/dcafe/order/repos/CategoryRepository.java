package com.dcafe.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.CategoryTable;

public interface CategoryRepository extends JpaRepository<CategoryTable, Integer> {

}
