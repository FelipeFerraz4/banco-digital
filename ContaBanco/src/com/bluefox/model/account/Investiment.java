package com.bluefox.model.account;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Investiment {
    private LocalDateTime startDate;
    private LocalDate lastUpdate;
    private double valueInvested;
    
    public Investiment(LocalDateTime startDate, LocalDate lastUpdate, double valueInvested) {
        this.startDate = startDate;
        this.lastUpdate = lastUpdate;
        this.valueInvested = valueInvested;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public double getValueInvested() {
        return valueInvested;
    }
    
    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setValueInvested(double valueInvested) {
        this.valueInvested = valueInvested;
    }

    @Override
    public String toString() {
        return "Investiment [startDate: " + startDate + ", lastUpdate: " + lastUpdate + ", valueInvested: "
                + valueInvested + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Investiment other = (Investiment) obj;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        return true;
    }


    
    
}
