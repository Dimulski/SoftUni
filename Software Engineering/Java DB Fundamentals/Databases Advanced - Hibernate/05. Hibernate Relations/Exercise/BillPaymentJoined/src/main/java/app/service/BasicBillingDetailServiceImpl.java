package app.service;

import app.domain.BasicBillingDetail;
import app.repositories.BasicBillingDetailRepository;
import app.service.contracts.BasicBillingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicBillingDetailServiceImpl implements BasicBillingDetailService {

    @Autowired
    private BasicBillingDetailRepository basicBillingDetailRepository;

    @Override
    public void create(BasicBillingDetail basicBillingDetail) {
        this.basicBillingDetailRepository.saveAndFlush(basicBillingDetail);
    }
}
