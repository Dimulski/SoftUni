package app.domain;

import app.domain.enums.Prediction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Enumerated(EnumType.STRING)
    private Prediction prediction;

    public ResultPrediction() {
        super();
    }

    public ResultPrediction(Prediction prediction) {
        this.setPrediction(prediction);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }
}
