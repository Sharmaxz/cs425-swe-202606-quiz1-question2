package cams.service;

import cams.service.dto.AccountResponse;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    List<AccountResponse> getAllAccountsSortedByBalanceDesc();
    List<AccountResponse> getPlatinumAccounts();
    BigDecimal getLiquidityPosition();
}
