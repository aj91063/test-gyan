package org.test.gyan.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.gyan.model.Category;
import org.test.gyan.model.SubCategory;

import java.util.List;
import java.util.Set;

@Repository
public interface SubCategoryRepositry extends JpaRepository<SubCategory, Long> {


}
