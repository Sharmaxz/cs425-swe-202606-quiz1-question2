package cams.service.dto;

import cams.domain.Customer;

public class CustomerResponse {
    private long customerId;
    private String firstName;
    private String lastName;

    public CustomerResponse(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
