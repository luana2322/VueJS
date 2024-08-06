package com.crudVuejs.repository;

import com.crudVuejs.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value="select p.*,c.categoryName,c.categoryId as cateId from product p \n" +
            "join category c\n" +
            "on p.categoryId=c.categoryId\n" +
            "where lower(p.productName) like lower(concat('%',:keyword,'%'))\n" +
            "or lower(p.price) like lower(concat('%',:keyword,'%'))\n" +
            "or lower(p.description) like lower(concat('%',:keyword,'%'))\n" +
            "or lower(p.manufactureDate) like lower(concat('%',:keyword,'%'))\n" +
            "or lower(p.image) like lower(concat('%',:keyword,'%'))\n" +
            "or lower(c.categoryName) like lower(concat('%',:keyword,'%'))",nativeQuery = true)
    List<Product> searchproduct(String keyword);
}
