package app.service;

import app.domain.Picture;
import app.repositories.PictureRepository;
import app.service.contracts.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public void create(Picture picture) {
        this.pictureRepository.saveAndFlush(picture);
    }
}
