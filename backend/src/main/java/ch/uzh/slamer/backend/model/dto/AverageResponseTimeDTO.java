package ch.uzh.slamer.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Date;

public class AverageResponseTimeDTO extends ServiceLevelObjectiveDTO {

    @JsonProperty
    private String relationalOperator;

    @JsonProperty
    private BigDecimal averageResponseTimeValue;

    @JsonProperty
    private String timeUnit;

    public AverageResponseTimeDTO() { }

    public AverageResponseTimeDTO(Integer id, String name, Date validFrom, Date validTo, Integer slaId, String sloType, String relationalOperator, BigDecimal averageResponseTimeValue, String timeUnit) {
        super(id, name, validFrom, validTo, slaId, sloType);
        this.relationalOperator = relationalOperator;
        this.averageResponseTimeValue = averageResponseTimeValue;
        this.timeUnit = timeUnit;
    }

    public String getRelationalOperator() {
        return relationalOperator;
    }

    public void setRelationalOperator(String relationalOperator) {
        this.relationalOperator = relationalOperator;
    }

    public BigDecimal getAverageResponseTimeValue() {
        return averageResponseTimeValue;
    }

    public void setAverageResponseTimeValue(BigDecimal averageResponseTimeValue) {
        this.averageResponseTimeValue = averageResponseTimeValue;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }
}

