package sample.mongo;

import java.util.List;

public class CustomerResponse {

    List<Customer> customerList;

    public CustomerResponse() { }

    public CustomerResponse(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
