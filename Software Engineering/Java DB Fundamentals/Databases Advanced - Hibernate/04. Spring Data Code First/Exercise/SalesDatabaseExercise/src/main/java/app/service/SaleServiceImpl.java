package app.service;

import app.domain.Sale;
import app.repositories.SaleRepository;
import app.service.contracts.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void create(Sale sale) {
        this.saleRepository.saveAndFlush(sale);
    }
}
