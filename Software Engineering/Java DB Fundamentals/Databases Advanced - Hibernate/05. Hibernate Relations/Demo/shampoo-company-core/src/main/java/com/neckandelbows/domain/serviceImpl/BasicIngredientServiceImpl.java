package com.neckandelbows.domain.serviceImpl;

import com.neckandelbows.dao.BasicIngredientDao;
import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.ingredients.Ingredient;
import com.neckandelbows.service.BasicIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicIngredientServiceImpl implements BasicIngredientService {

    @Autowired
    private BasicIngredientDao basicIngredientDao;

    @Override
    public void create(BasicIngredient basicIngredient) {
        basicIngredientDao.saveAndFlush(basicIngredient);
    }

    @Override
    public BasicIngredient retrieve(long id) {
        return basicIngredientDao.findOne(id);
    }
}
