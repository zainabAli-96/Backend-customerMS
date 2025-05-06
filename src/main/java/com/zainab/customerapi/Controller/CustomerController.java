package com.zainab.customerapi.Controller;

import com.zainab.customerapi.Entity.CustomerEntity;
import com.zainab.customerapi.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @PostMapping("/add")
    public ResponseEntity<CustomerEntity> createContact(@RequestBody CustomerEntity customer){
        CustomerEntity createdCustomer = customerService.addCustomer(customer);
        return ResponseEntity.created(URI.create("/customers/" + createdCustomer.getId())).body(createdCustomer);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerEntity>> getAllCustomers(){
        List<CustomerEntity> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity customerData) {
        CustomerEntity updatedCustomer = customerService.updateCustomer(id, customerData);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
