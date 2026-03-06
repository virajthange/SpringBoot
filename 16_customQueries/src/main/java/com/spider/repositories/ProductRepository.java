package com.spider.repositories;

import com.spider.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT product FROM Product product WHERE product.category = ?1")
    public List<Product> findByCat(String category);

    @Query("SELECT product FROM Product product WHERE product.price = ?1")
    public Product findByPri(Integer price);


    //    ******************************************************************************************
//    without @Query

//    Spring parses the method name from left to right, so the order of keywords matters.
//    1️⃣ Method Must Start With a Query Prefix
//    Every derived query method must start with one of these:
//    Prefix	Meaning
//    findBy	Fetch records
//    readBy	Same as find
//    getBy	    Same as find
//    queryBy	Same as find
//    countBy	Count records
//    existsBy	Check if record exists
//    deleteBy	Delete records


//    The method must use entity field names, not database column names.
//    3️⃣ Operators Come After the Field
//    Structure:
//    findBy + FieldName + Operator
//    Case-Insensitive Must Come At the End of Field
//    Multiple Conditions Order
//    Structure:
//    findByField1OperatorAndField2Operator
//    findTopNByFieldOperatorAndFieldOperatorOrderByFieldAsc/Desc

//    Prefix → Conditions → Operators → IgnoreCase → OrderBy

    public List<Product> findByBrand(String brand);

    //    For case-insensitive search
    public List<Product> findByBrandIgnoreCase(String brand);

    public Optional<Product> findById(Integer id);

    public List<Product> findByBrandAndCategory(String brand, String category);

    public List<Product> findByPriceGreaterThan(Integer price);

    public List<Product> findByBrandStartingWith(String prefix);


//    1️⃣ Comparison Operators
//List<Product> findByPriceGreaterThan(Integer price);
    List<Product> findByPriceGreaterThanEqual(Integer price);
    List<Product> findByPriceLessThan(Integer price);
    List<Product> findByPriceLessThanEqual(Integer price);
    List<Product> findByPriceBetween(Integer min, Integer max);


//    2️⃣ Equality / Inequality
    List<Product> findByCategory(String category);

    List<Product> findByCategoryNot(String category);

//    3️⃣ Logical Operators
//  List<Product> findByBrandAndCategory(String brand, String category);

    List<Product> findByBrandOrCategory(String brand, String category);

//    4️⃣ String Matching Operators
    List<Product> findByBrandLike(String brand);
    List<Product> findByBrandContaining(String brand);
//    List<Product> findByBrandStartingWith(String prefix);
    List<Product> findByBrandEndingWith(String suffix);

//    5️⃣ Case-Insensitive Operators
//    List<Product> findByBrandIgnoreCase(String brand);
    List<Product> findByCategoryContainingIgnoreCase(String category);

//    6️⃣ Collection Operators
    List<Product> findByCategoryIn(List<String> categories);
    List<Product> findByCategoryNotIn(List<String> categories);

//    7️⃣ Null Operators
    List<Product> findByDescriptionIsNull();
    List<Product> findByDescriptionIsNotNull();

//    8️⃣ Boolean Operators (if a field is boolean)
    List<Product> findByAvailableTrue();
    List<Product> findByAvailableFalse();

//    9️⃣ Sorting Operators
    List<Product> findByCategoryOrderByPriceAsc(String category);
    List<Product> findByCategoryOrderByPriceDesc(String category);

//    🔟 Limit / Top Results
    List<Product> findTop5ByCategory(String category);
    List<Product> findFirst3ByCategory(String category);

//    1️⃣1️⃣ Distinct
    List<Product> findDistinctByCategory(String category);

//    If we want to use IgnoreCase for all the fields, insted of using it 2 times do this:
//    List<Product> findByBrandAndCategoryAllIgnoreCase(String brand, String category);

//    In Spring Data JPA, derived query methods (method-name queries) support many operators, but GROUP BY and HAVING are NOT supported in method names.
//    For these operations you must use @Query with JPQL or native SQL.


}