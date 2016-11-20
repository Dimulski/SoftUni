package app.service;

import app.domain.BedType;
import app.repositories.BedTypeRepository;
import app.service.contracts.BedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedTypeServiceImpl implements BedTypeService {

    @Autowired
    private BedTypeRepository bedTypeRepository;

    @Override
    public void create(BedType bedType) {
        this.bedTypeRepository.saveAndFlush(bedType);
    }
}
