package app.service;

import app.domain.Color;
import app.repositories.ColorRepository;
import app.service.contracts.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public void create(Color color) {
        this.colorRepository.saveAndFlush(color);
    }
}
