package app.service;

import app.domain.RoomStatus;
import app.repositories.RoomStatusRepository;
import app.service.contracts.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

    @Autowired
    private RoomStatusRepository roomStatusRepository;

    @Override
    public void create(RoomStatus roomStatus) {
        this.roomStatusRepository.saveAndFlush(roomStatus);
    }
}
