package com.neckandelbows.service;


import com.neckandelbows.dao.BasicIngredientDao;
import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.ingredients.Ingredient;

public interface BasicIngredientService {

    void create(BasicIngredient basicIngredient);

    BasicIngredient retrieve(long id);
}
