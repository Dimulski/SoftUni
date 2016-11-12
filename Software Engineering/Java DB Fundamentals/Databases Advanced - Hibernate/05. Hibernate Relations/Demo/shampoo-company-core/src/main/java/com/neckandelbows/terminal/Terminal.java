package com.neckandelbows.terminal;

import com.neckandelbows.domain.batches.ProductionBatch;
import com.neckandelbows.domain.ingredients.*;
import com.neckandelbows.domain.labels.ClassicLabel;
import com.neckandelbows.domain.shampoos.BasicShampoo;
import com.neckandelbows.domain.shampoos.FiftyShade;
import com.neckandelbows.domain.shampoos.FreshNuke;
import com.neckandelbows.service.BasicIngredientService;
import com.neckandelbows.service.BasicShampooService;
import com.neckandelbows.service.ClassicLabelService;
import com.neckandelbows.service.ProductionBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private BasicIngredientService basicIngredientService;

    @Autowired
    private BasicShampooService basicShampooService;

    @Autowired
    private ProductionBatchService productionBatchService;

    @Autowired
    private ClassicLabelService classicLabelService;

    @Override
    public void run(String... strings) throws Exception {

        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();
        this.basicIngredientService.create(am);
        this.basicIngredientService.create(mint);
        this.basicIngredientService.create(nettle);

        ProductionBatch productionBatch = new ProductionBatch(new Date());
        this.productionBatchService.create(productionBatch);

        ClassicLabel classicLabelOne = new ClassicLabel("Aweseom Tittle", "Subtitle");
        this.classicLabelService.create(classicLabelOne);

        ClassicLabel classicLabelTwo = new ClassicLabel("Aweseom 2", "Subtitle2");
        this.classicLabelService.create(classicLabelTwo);

        BasicShampoo basicShampooOne = new FreshNuke(classicLabelOne,productionBatch);
        basicShampooOne.getIngredients().add(am);
        basicShampooOne.getIngredients().add(nettle);

        BasicShampoo basicShampooTwo = new FiftyShade(classicLabelTwo,productionBatch);
        basicShampooTwo.getIngredients().add(am);
        basicShampooTwo.getIngredients().add(mint);

        this.basicShampooService.create(basicShampooOne);
        this.basicShampooService.create(basicShampooTwo);
    }
}
