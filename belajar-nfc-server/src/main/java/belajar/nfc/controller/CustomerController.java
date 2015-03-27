/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.nfc.controller;

import belajar.nfc.domain.Customer;
import belajar.nfc.service.CustomerDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andikha
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerDao.findAll(pageable);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer findOne(@PathVariable(value = "id") String id) {
        return customerDao.findOne(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void saveCustomer(@RequestBody Customer customer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (customer == null) {
            throw new Exception("Tidak boleh kosong");
        }
        customerDao.save(customer);

    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable(value = "id") String id) throws Exception {
        if (id == null) {
            throw new Exception("id tidak ada");
        }

        Customer customer = customerDao.findOne(id);

        if (customer == null) {
            throw new Exception("Data tidak ditemukan");
        }
        customerDao.delete(customer);
    }

}
