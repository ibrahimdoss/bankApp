package com.App.service;

import com.App.model.Customer;

import java.util.List;

public class CustomerService {

    public List<Customer> createCustomer (Customer customer, List<Customer> customerList){
        customerList.add(customer);
        return customerList;
    }

    public List<Customer> updateCustomer (Customer customer, Integer customerId, List<Customer> customerList){
        Customer oldCustomer = new Customer();
        for (int i = 0; i < customerList.size(); i++){
            if (customerId.equals(customerList.get(i).getId())){
                oldCustomer = customerList.get(i);
                customerList.remove(i);
                break;

            }
        }
        oldCustomer.setAddress(customer.getAddress());
        oldCustomer.setBirthdate(customer.getBirthdate());
        oldCustomer.setCity(customer.getCity());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setName(customer.getName());
        oldCustomer.setPhone(customer.getPhone());

        customerList.add(oldCustomer);

        return customerList;

    }

    public List<Customer> deleteCustomer (String customerId, List<Customer> customerList) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerId.equals(customerList.get(i).getId())) {
                customerList.remove(i);
                break;

            }
        }
        return customerList;
    }

    public Customer getCustomer(String customerId, List<Customer> customerList){
        Customer customer = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerId.equals(customerList.get(i).getId())) {
                customer = customerList.get(i);
                break;

            }
        }
        return customer;
    }
}
