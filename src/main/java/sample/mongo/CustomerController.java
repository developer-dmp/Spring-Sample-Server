package sample.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sample.responses.Response;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping("addAllCustomers")
    public Response addAll() {
        // save a couple of customers
        repository.save(new Customer("Russell", "Epstein", "Male"));
        repository.save(new Customer("Domenic", "Polidoro", "Male"));
        repository.save(new Customer("Luis", "Echegorri", "Female"));
        repository.save(new Customer("Robert", "Herbert", "Female"));
        repository.save(new Customer("Chris", "Kim", "Undefined"));

        return new Response(true, "Added all dummy customers");
    }

    @RequestMapping("deleteAllCustomers")
    public Response deleteAll() {
        repository.deleteAll();
        return new Response(true, "Deleted all customers");
    }

    @RequestMapping("/addCustomer")
    public Response addCustomer(
            @RequestParam(value="first_name", defaultValue="") String firstName,
            @RequestParam(value="last_name", defaultValue="") String lastName,
            @RequestParam(value="gender", defaultValue="") String gender
    ) {

        // check to make sure we have all the required fields
        if (firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty()) {
            return new Response(false, "Please provide a valid first name, last name, and gender.");
        }

        repository.save(new Customer(firstName, lastName, gender));
        return new Response(true, "Added new customer: ["+gender+"] "+firstName+" "+lastName);
    }

    @RequestMapping("/getAllCustomers")
    public CustomerResponse getAllCustomers() {
        return new CustomerResponse(repository.findAll());
    }

    @RequestMapping("/getCustomersByFirstName")
    public CustomerResponse getByFirstName(
            @RequestParam(value="first_name", defaultValue="") String firstName
    ) {
        return new CustomerResponse(repository.findByFirstName(firstName));
    }

    @RequestMapping("/getCustomersByLastName")
    public CustomerResponse getByLastName(
            @RequestParam(value="last_name", defaultValue="") String lastName
    ) {
        return new CustomerResponse(repository.findByLastName(lastName));
    }

    @RequestMapping("/getCustomersByGender")
    public CustomerResponse getByGender(
            @RequestParam(value="gender", defaultValue="") String gender
    ) {
        return new CustomerResponse(repository.findByGender(gender));
    }
}
