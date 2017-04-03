package softuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.repository.CapitalRepository;
import softuni.service.contracts.CapitalService;

import java.util.List;

@Service
public class CapitalServiceImpl implements CapitalService {

    @Autowired
    private CapitalRepository capitalRepository;
    
    @Override
    public List<String> getCapitals() {
        return this.capitalRepository.getCapitalNames();
    }
}
