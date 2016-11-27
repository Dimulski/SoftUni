package app.service;

import app.domain.ResultPrediction;
import app.repositories.ResultPredictionRepository;
import app.service.contracts.ResultPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultPredictionServiceImpl implements ResultPredictionService {

    @Autowired
    private ResultPredictionRepository resultPredictionRepository;

    @Override
    public void create(ResultPrediction resultPrediction) {
        this.resultPredictionRepository.saveAndFlush(resultPrediction);
    }
}
