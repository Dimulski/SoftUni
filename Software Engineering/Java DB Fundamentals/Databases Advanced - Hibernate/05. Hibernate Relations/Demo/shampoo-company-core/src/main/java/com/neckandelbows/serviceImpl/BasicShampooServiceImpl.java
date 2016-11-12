package com.neckandelbows.serviceImpl;

import com.neckandelbows.dao.BasicIngredientDao;
import com.neckandelbows.dao.BasicShampooDao;
import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.shampoos.BasicShampoo;
import com.neckandelbows.service.BasicIngredientService;
import com.neckandelbows.service.BasicShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicShampooServiceImpl implements BasicShampooService {

    @Autowired
    private BasicShampooDao basicShampooDao;

    @Override
    public void create(BasicShampoo basicShampoo) {
        basicShampooDao.saveAndFlush(basicShampoo);
    }
}
