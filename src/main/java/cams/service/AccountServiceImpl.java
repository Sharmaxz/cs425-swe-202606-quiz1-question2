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
    
    // We use the specified date 2026-06-04 to calculate tiers accurately
    private final LocalDate evaluationDate = LocalDate.of(2026, 6, 4);

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountResponse> getAllAccountsSortedByBalanceDesc() {
        return accountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account::getBalance).reversed())
                .map(acc -> new AccountResponse(acc, acc.getTier(evaluationDate)))
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountResponse> getPlatinumAccounts() {
        return accountRepository.findAll().stream()
                .filter(acc -> acc.getTier(evaluationDate) == AccountTier.PLATINUM)
                .sorted(Comparator.comparing(Account::getBalance).reversed())
                .map(acc -> new AccountResponse(acc, AccountTier.PLATINUM))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getLiquidityPosition() {
        return accountRepository.findAll().stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
