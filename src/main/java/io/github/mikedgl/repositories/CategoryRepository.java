package io.github.mikedgl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mikedgl.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	 
}
