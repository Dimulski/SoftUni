package app.repositories;

import app.domain.ResultPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultPredictionRepository extends JpaRepository<ResultPrediction, Long> {

}
