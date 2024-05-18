package com.bluefox.model.account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bluefox.utils.Rate;

public class SavingAccount extends Account{

    private List<Investiment> investiments;

    public SavingAccount() {
        super("saving account");
        this.investiments = new ArrayList<>();
    }

    public void addInvestment(double value) {
        investiments.add(new Investiment(LocalDateTime.now(), LocalDate.now(), value));
    }

    public double getTotalInvested() {
        if(investiments.isEmpty()) {
            // throw new EmptySavingAccountException();
            return 0;
        }

        investiments = investiments.stream().map(investiment -> updateInvestment(investiment)).collect(Collectors.toList());

        return investiments.stream().mapToDouble(investiment -> investiment.getValueInvested()).sum();
    }

    private Investiment updateInvestment(Investiment investiment) {
        Period period = Period.between(investiment.getLastUpdate(), LocalDate.now());

        if(period.getYears() > 0 || period.getMonths() > 0) {
            double months = (double) period.getYears() + period.getMonths();
            double newValue = investiment.getValueInvested() * Math.pow(1 + this.getCurrentRate(), months);
            investiment.setLastUpdate(LocalDate.now());
            investiment.setValueInvested(newValue);
        }

        return investiment;
    }

    public double getCurrentRate() {
        double selic = Rate.SELIC.getValue();
        double referenceRate = Rate.REFERENCE_RATE.getValue();
        return selic > 0.085 ? 0.0617 + referenceRate : (0.7 * selic) + referenceRate;
    }

    @Override
    public String getAccountData() {
        return String.format("==== Saving Account ====%n" +
        "Bank Branch: %04d%n" +
        "Account Number: %06d%n" +
        "Bank Balance: R$ %.2f" , 
        this.getBankBranch(), 
        this.getAccountNumber(), 
        this.getBankBalance());
    }
}
