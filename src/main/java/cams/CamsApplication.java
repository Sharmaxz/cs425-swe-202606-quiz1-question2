package cams;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import cams.repository.AccountRepository;
import cams.repository.InMemoryAccountRepository;
import cams.service.AccountService;
import cams.service.AccountServiceImpl;
import cams.service.dto.AccountResponse;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CamsApplication {

    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the Customer-Accounts Management!");

        // Initialization
        AccountRepository accountRepository = new InMemoryAccountRepository();
        AccountService accountService = new AccountServiceImpl(accountRepository);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        /*
         Task 1: Display list of all Accounts in JSON format (sorted by balance descending)

         Display list of all Accounts in JSON format (Allows the user to view a list of all the
         accounts registered in the system, including the customer data and the Account’s tier).

         The Bank requires this list to be displayed sorted in descending order of the Account balance amounts.
         */
        System.out.println("Task 1: JSON Array of All Accounts Data, sorted by Balance in descending order.");
        System.out.println("----------------------------------------------------------------------------------");
        List<AccountResponse> allAccounts = accountService.getAllAccountsSortedByBalanceDesc();
        try {
            String jsonAllAccounts = mapper.writeValueAsString(allAccounts);
            System.out.println(jsonAllAccounts);
        } catch (JsonProcessingException e) {
            System.err.println("Error processing JSON for all accounts: " + e.getMessage());
        }

        // Display Liquidity Position
        System.out.println("\nLiquidity Position (Sum of all Account balances): " 
                + currencyFormat.format(accountService.getLiquidityPosition()));
        System.out.println("==================================================================================\n");

        //


        // Task 2: Display list of only Platinum tier Accounts in JSON format
        System.out.println("Task 2: JSON Array of Platinum tier Accounts Data.");
        System.out.println("----------------------------------------------------------------------------------");
        List<AccountResponse> platinumAccounts = accountService.getPlatinumAccounts();
        try {
            String jsonPlatinumAccounts = mapper.writeValueAsString(platinumAccounts);
            System.out.println(jsonPlatinumAccounts);
        } catch (JsonProcessingException e) {
            System.err.println("Error processing JSON for Platinum accounts: " + e.getMessage());
        }
        System.out.println("==================================================================================");
    }
}
