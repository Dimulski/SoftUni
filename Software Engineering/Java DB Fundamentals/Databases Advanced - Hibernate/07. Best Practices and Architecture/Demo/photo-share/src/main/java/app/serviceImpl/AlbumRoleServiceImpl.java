package app.serviceImpl;

import app.domain.model.AlbumRole;
import app.repository.AlbumRoleRepository;
import app.service.AlbumRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumRoleServiceImpl implements AlbumRoleService {

    @Autowired
    private AlbumRoleRepository albumRoleRepository;

    @Override
    public void create(AlbumRole albumRole) {
        this.albumRoleRepository.save(albumRole);
    }
}
