package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Product;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//
//    // find...By
//    Optional<Product> findByNumber(Long number);
//    List<Product> findAllByName(String name);
//    Product queryByNumber(Long number);
//
//    // exists...By
//    boolean existsByNumber(Long number);
//
//    // count...By
//    long countByName(String name);
//
//    // delete...By, remove...By
//    void deleteByNumber(Long number);
//    long removeByName(String name);
//
//    // ...First<number>..., ...Top<number>...
//    List<Product> findFirst5ByName(String name);
//    List<Product> findTop10ByName(String name);
//
//    // Is: Operates identically to the findByNumber method
//    Product findByNumberIs(Long number);
//    Product findByNumberEquals(Long number);
//
//    // (IS)Not: Condition for mismatch of values
//    Product findByNumberIsNot(Long number);
//    Product findByNumberNot(Long number);
//
//    // (IS)Null, (Is)NotNull: Check if value is null
//    List<Product> findByUpdatedAtNull();
//    List<Product> findByUpdatedAtISNull();
//    List<Product> findByUpdatedAtNotNull();
//    List<Product> findByUpdatedAtIsNotNull();
//
//    // (Is)True, (Is)False: Check the column value specified as boolean type
//    Product findByisActiveTrue();
//    Product findByisActiveIsTrue();
//    Product findByisActiveFalse();
//    Product findByisActiveIsFalse();
//
//    // And, Or: For bundling multiple conditions
//    Product findByNumberAndName(Long number, String name);
//    Product findByNumberOrName(Long number, String name);
//
//    // (Is)GreaterThan, (Is)LessThan, (Is)Between:
//    // Predicate keyword that can be used in comparison operations targeting numeric or datetime columns.
//    // Over/under comparison. Add Equals keyword when including threshold value
//    List<Product> findByPriceIsGreaterThan(Long price);
//    List<Product> findByPriceGreaterThan(Long price);
//    List<Product> findByPriceGreaterThanEqual(Long price);
//    List<Product> findByPriceIsLessThan(Long price);
//    List<Product> findByPriceLessThan(Long price);
//    List<Product> findByPriceLessThanEqual(Long price);
//    List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
//    List<Product> findByPRiceBetween(Long lowPrice, Long highPrice);
//
//    // (Is)StartingWith(==StartsWith), (Is)EndingWith(==EndsWith), (Is)Containing(==Contains), (Is)Like
//    // This is a predicate keyword that checks for partial matches in column values. A keyword that plays
//    // the same role as the '%' keyword used when extracting a value containing part of a value in an
//    // SQL query statement.
//    //Containing: '%' is placed at both ends of the string
//    //StartingWith: '%' is placed in front of the string
//    //EndingWith: '%' is placed at the end of the string
//    //Like: Must explicitly place '%' in the value passed while calling the method at the code level.
//    List<Product> findByNameLike(String name);
//    List<Product> findByNameIsLike(String name);
//    List<Product> findByNameContains(String name);
//    List<Product> findByNameIsContaining(String name);
//
//    List<Product> findByNameStartsWith(String name);
//    List<Product> findByNameContaining(String name);
////    List<Product> findByNameIsContaining(String name); already defined
//    List<Product> findByNameIsStartingWith(String name);
//
//    List<Product> findByNameEndsWith(String name);
//    List<Product> findByNameEndingWith(String name);
//    List<Product> findByNameIsEndingWith(String name);
//
//    // Asc: Ascending order, Desc: Descending order
//    List<Product> findByNameOrderByNumberAsc(String name);
//    List<Product> findByNameOrderByNumberDesc(String name);

    // Using multiple sort criteria in query methods. Unlike
    // other query methods, "And" and "Or" keywords are omitted.
//    List<Product> findByNameOrderByPriceAscStockDesc(String name);

    // Query sorting using parameters to improve readability of method names.
    // Instead of including keywords in the name, use the Sort object and
    // use the sorting criteria accepted as parameters.
//    List<Product> findByName(String name, Sort sort);

//    Page<Product> findByName(String name, Pageable pageable);

//    @Query("SELECT p FROM Product AS p WHERE p.name = :name")
//    List<Product> findByNameParam(@Param("name") String name);

    @Query("SELECT p.name, p.price, p.stock FROM Product AS p WHERE p.name= :name")
    List<Object[]> findByNameParam2(@Param("name") String name);



}
