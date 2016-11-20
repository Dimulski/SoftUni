package app.service;

import app.domain.RoomType;
import app.repositories.RoomTypeRepository;
import app.service.contracts.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public void create(RoomType roomType) {
        this.roomTypeRepository.saveAndFlush(roomType);
    }
}
