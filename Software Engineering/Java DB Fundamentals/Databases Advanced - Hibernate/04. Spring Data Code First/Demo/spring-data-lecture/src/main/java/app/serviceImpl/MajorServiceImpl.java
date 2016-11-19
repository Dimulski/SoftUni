package app.serviceImpl;

import app.dao.MajorDao;
import app.domain.Major;
import app.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements MajorService {

    private final MajorDao majorDao;

    @Autowired
    public MajorServiceImpl(MajorDao majorDao) {
        this.majorDao = majorDao;
    }

    @Override
    public void create(Major major) {
        this.majorDao.saveAndFlush(major);
    }

    @Override
    public void deleteByName(String name) {
        majorDao.deleteByName(name);
    }
}
