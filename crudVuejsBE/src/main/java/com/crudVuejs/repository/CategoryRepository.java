package com.crudVuejs.repository;

import com.crudVuejs.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value="select c.*,p.productId,p.categoryId as cateid from category c \n" +
            "join product p\n" +
            "on p.categoryId=c.categoryId\n" +
            "where p.productId=?1",nativeQuery = true)
    Category findCategoriesByProductId(Long productId);
}
