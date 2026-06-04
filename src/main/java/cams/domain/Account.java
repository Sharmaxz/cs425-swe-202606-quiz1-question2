package cams.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Account {
    private long accountId;
    private String accountNumber;
    private String accountType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOpened;
    private BigDecimal balance;
    private Customer customer;

    public Account() {
    }

    public Account(long accountId, String accountNumber, String accountType, LocalDate dateOpened, BigDecimal balance, Customer customer) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.balance = balance;
        this.customer = customer;
    }

    // region Getters and Setters

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // endregion Getters and Setters

    public AccountTier getTier(LocalDate currentDate) {
        if (dateOpened == null || balance == null) {
            return AccountTier.NONE;
        }

        int years = Period.between(dateOpened, currentDate).getYears();
        
        if (years >= 10 && balance.compareTo(new BigDecimal("100000")) >= 0) {
            return AccountTier.PLATINUM;
        } else if (years >= 5 && balance.compareTo(new BigDecimal("50000")) >= 0) {
            return AccountTier.GOLD;
        } else if (years >= 2 && balance.compareTo(new BigDecimal("10000")) >= 0) {
            return AccountTier.SILVER;
        }
        
        return AccountTier.NONE;
    }
}
