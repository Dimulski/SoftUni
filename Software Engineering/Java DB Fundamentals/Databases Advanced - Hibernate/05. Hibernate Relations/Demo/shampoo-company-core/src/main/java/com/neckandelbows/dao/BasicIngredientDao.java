package com.neckandelbows.dao;

import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.ingredients.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicIngredientDao extends JpaRepository<BasicIngredient, Long>{
}
