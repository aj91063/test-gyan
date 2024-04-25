package org.test.gyan.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.test.gyan.model.Category;
import org.test.gyan.model.SubCategory;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SubCategoryRepositry extends JpaRepository<SubCategory, Long> {

    @Query("SELECT sc FROM SubCategory sc\n" +
            "JOIN sc.category ca\n" +
            "WHERE sc.subCategoryName= :subCategoryName AND ca.categoryName= :categoryName")
    List<SubCategory> findBySubCategoryNameAndCategoryName(
            @Param("subCategoryName") String subCategoryName,
            @Param("categoryName") String categoryName);
}
