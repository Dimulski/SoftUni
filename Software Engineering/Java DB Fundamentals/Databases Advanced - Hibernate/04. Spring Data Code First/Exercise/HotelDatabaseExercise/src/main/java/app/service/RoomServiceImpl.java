package app.service;

import app.domain.Room;
import app.repositories.RoomRepository;
import app.service.contracts.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void create(Room room) {
        this.roomRepository.saveAndFlush(room);
    }
}
