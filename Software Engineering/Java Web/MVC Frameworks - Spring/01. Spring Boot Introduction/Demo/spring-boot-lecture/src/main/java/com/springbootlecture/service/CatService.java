package com.springbootlecture.service;

import com.springbootlecture.models.CatModel;
import org.springframework.stereotype.Service;

@Service
public interface CatService {

    void buy(CatModel catModel);
}
