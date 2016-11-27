package app.repositories;

import app.domain.BasicBillingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicBillingDetailRepository extends JpaRepository<BasicBillingDetail, String>{

}
