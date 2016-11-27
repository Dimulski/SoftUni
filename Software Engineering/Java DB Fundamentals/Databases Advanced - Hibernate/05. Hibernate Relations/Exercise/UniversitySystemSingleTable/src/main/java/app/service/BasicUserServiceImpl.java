package app.service;

import app.domain.BasicUser;
import app.repositories.BasicUserRepository;
import app.service.contracts.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicUserServiceImpl implements BasicUserService {

    @Autowired
    private BasicUserRepository basicUserRepository;

    @Override
    public void create(BasicUser basicUser) {
        this.basicUserRepository.saveAndFlush(basicUser);
    }
}
