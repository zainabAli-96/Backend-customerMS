package com.zainab.customerapi.Service;

import com.zainab.customerapi.Entity.CustomerEntity;
import com.zainab.customerapi.Exceptions.ResourceNotFoundException;
import com.zainab.customerapi.Repository.CustomerRepository;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerEntity> getAllCustomers(){
        return customerRepository.findAll();
    }
    public CustomerEntity addCustomer(CustomerEntity customerEntity){
        if(customerEntity.getRegisteredOn() == null){
        customerEntity.setRegisteredOn(new Timestamp(System.currentTimeMillis()));}
        return customerRepository.save(customerEntity);
    }
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Optional<CustomerEntity> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public CustomerEntity updateCustomer(Long id, CustomerEntity customerData) {
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customer.setFirst_name(customerData.getFirst_name());
        customer.setLast_name(customerData.getLast_name());
        customer.setEmail(customerData.getEmail());
        customer.setPhone(customerData.getPhone());
        customer.setAddress(customerData.getAddress());
        customer.setBirth_date(customerData.getBirth_date());
        return customerRepository.save(customer);

    }
}
