package com.bluefox.model.account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bluefox.exception.account.InsufficientBankBalanceException;
import com.bluefox.exception.account.InvalidValue;
import com.bluefox.utils.Rate;

public class SavingAccount extends Account{

    private List<Investiment> investiments;

    public SavingAccount() {
        super("saving account");
        this.investiments = new ArrayList<>();
    }

    public void addInvestment(double value) {
        investiments.add(new Investiment(LocalDateTime.now(), value));
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

    public void savingDeposit(double value, Account account) throws InvalidValue, InsufficientBankBalanceException {
        if (value < 0.01) {
            throw new InvalidValue("Invalid value, withdraw at least R$ 0,01");
        } else if (account.getBankBalance() < value) {
            throw new InsufficientBankBalanceException();
        }

        account.setBankBalance(account.getBankBalance() - value);

        this.setBankBalance(getTotalInvested());
        
        this.setBankBalance(this.getBankBalance() + value);
        addInvestment(value);
    }

    public void savingWithdraw(double value, Account account) throws InvalidValue, InsufficientBankBalanceException {
        this.setBankBalance(getTotalInvested());

        if (value < 0.01) {
            throw new InvalidValue("Invalid value, withdraw at least R$ 0,01");
        } else if (this.getBankBalance() < value) {
            throw new InsufficientBankBalanceException();
        }
        this.setBankBalance(this.getBankBalance() - value);

        removeInvestment(value);

        account.setBankBalance(account.getBankBalance() + value);
    }

    private void removeInvestment(double value) throws InsufficientBankBalanceException {
        List<Investiment> investimentToRemove = new ArrayList<>();

        int i = investiments.size() - 1;
        while(value > 0 && i >= 0) {
            Investiment investiment = investiments.get(i);
            
            if (investiment.getValueInvested() > value) {
                investiments.get(i).setValueInvested(investiment.getValueInvested() - value);
                value = 0;
            } else if (investiment.getValueInvested() == value) {
                investimentToRemove.add(investiment);
                value = 0;
            } else {
                investimentToRemove.add(investiment);
                value = value - investiment.getValueInvested();
            }
            i -= 1;
        }

        if (!investimentToRemove.isEmpty()) {
            investiments.removeAll(investimentToRemove);
        }

    }

}
