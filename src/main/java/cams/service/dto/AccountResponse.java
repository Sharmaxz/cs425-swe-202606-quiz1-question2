package cams.service.dto;

import cams.domain.Account;
import cams.domain.AccountTier;

import java.math.BigDecimal;

public class AccountResponse {
    private long accountId;
    private String accountNumber;
    private String accountType;
    private String dateOpened;
    private BigDecimal balance;
    private AccountTier tier;
    private CustomerResponse customer;

    public AccountResponse(Account account, AccountTier tier) {
        this.accountId = account.getAccountId();
        this.accountNumber = account.getAccountNumber();
        this.accountType = account.getAccountType();
        this.dateOpened = account.getDateOpened().toString();
        this.balance = account.getBalance();
        this.tier = tier;
        this.customer = new CustomerResponse(account.getCustomer());
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountTier getTier() {
        return tier;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }
}
