package app.serviceImpl;

import app.domain.model.Picture;
import app.repository.PictureRepository;
import app.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public void create(Picture picture) {
        this.pictureRepository.save(picture);
    }
}
