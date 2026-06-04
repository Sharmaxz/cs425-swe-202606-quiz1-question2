package cams.service;

import cams.domain.Account;
import cams.domain.AccountTier;
import cams.repository.AccountRepository;
import cams.service.dto.AccountResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountResponse> getAllAccountsSortedByBalanceDesc() {
        LocalDate evaluationDate = LocalDate.now();

        return accountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account::getBalance).reversed())
                .map(account -> new AccountResponse(account, account.getTier(evaluationDate)))
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountResponse> getPlatinumAccounts() {
        LocalDate evaluationDate = LocalDate.now();

        return accountRepository.findAll().stream()
                .filter(account -> account.getTier(evaluationDate) == AccountTier.PLATINUM)
                .sorted(Comparator.comparing(Account::getBalance).reversed())
                .map(account -> new AccountResponse(account, account.getTier(evaluationDate)))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getLiquidityPosition() {
        return accountRepository.findAll().stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}