package cams.repository;

import cams.domain.Account;
import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
}
