package com.neckandelbows.dao;

import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicShampooDao extends JpaRepository<BasicShampoo, Long>{
}
