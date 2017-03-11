package com.springbootlecture.serviceImpl;

import com.springbootlecture.entities.Cat;
import com.springbootlecture.models.CatModel;
import com.springbootlecture.repository.CatRepository;
import com.springbootlecture.service.CatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CatRepository catRepository;

    @Override
    public void buy(CatModel catModel) {
        Cat cat = this.modelMapper.map(catModel, Cat.class);
        this.catRepository.save(cat);
    }
}
