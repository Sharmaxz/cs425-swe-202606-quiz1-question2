package cams.repository;

import cams.domain.Account;
import cams.domain.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {

    private final List<Account> accounts;

    public InMemoryAccountRepository() {
        accounts = new ArrayList<>();
        initData();
    }

    private void initData() {
        // Customers
        Customer c1 = new Customer(1, "Bob", "Jones");
        Customer c2 = new Customer(2, "Anna", "Smith");
        Customer c3 = new Customer(3, "Carlos", "Jimenez");

        // Accounts
        accounts.add(new Account(1, "AC1002", "Checking", LocalDate.of(2016, 5, 17), new BigDecimal("155900.50"), c1));
        accounts.add(new Account(2, "AS1001", "Savings", LocalDate.of(2021, 6, 2), new BigDecimal("12500.95"), c1));
        accounts.add(new Account(3, "AS1003", "Savings", LocalDate.of(2016, 7, 11), new BigDecimal("75000.00"), c3));
        accounts.add(new Account(4, "AC1004", "Checking", LocalDate.of(2024, 3, 29), new BigDecimal("11700.99"), c2));
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts);
    }
}
