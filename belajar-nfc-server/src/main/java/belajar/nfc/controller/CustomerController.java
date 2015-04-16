/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.nfc.controller;

import belajar.nfc.domain.Customer;
import belajar.nfc.service.CustomerDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author andikha
 */
@RestController
@RequestMapping("/api/customer")
@Transactional
public class CustomerController extends OptionsController{

    @Autowired
    private CustomerDao customerDao;

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET)
    public Page<Customer> findAllCustomer(Pageable pageable) {
        Page<Customer> result = customerDao.findAll(pageable);
        for (Customer r : result) {
            if(r.getFoto()!=null){
                r.setBase64("data:image/jpg;base64," + Base64.encodeBase64String(r.getFoto()));
            } else {
                r.setBase64("");
            }
            r.setFoto(null);
        }
        return result;
    }
    
    @Transactional(readOnly = true)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer findOne(@PathVariable(value = "id") String id) {
        Customer c = customerDao.findOne(id);
        if(c.getFoto()!=null){
            c.setBase64("data:image/jpg;base64," + Base64.encodeBase64String(c.getFoto()));
        } else {
            c.setBase64("");
        }
        c.setFoto(null);
        return c;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public void saveCustomer(
            @PathVariable String id, @RequestParam("foto") MultipartFile multipartFile,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        Customer customer = findOne(id);
        
        if(customer==null) customer=new Customer();
        
        customer.setNama(request.getParameter("nama"));
        customer.setAlamat(request.getParameter("alamat"));
        customer.setEmail(request.getParameter("email"));
        String customerDate = request.getParameter("tanggalLahir");
        SimpleDateFormat formatDdate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatDdate.parse(customerDate);
        customer.setTanggalLahir(date);
        
        byte[] buf = multipartFile.getBytes();
        customer.setFoto(buf);
        customerDao.save(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
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
    
    @RequestMapping(value = "/print/card/{id}", method = RequestMethod.GET)
    public String statusResponse(@PathVariable(value = "id") String id) throws Exception{
        String status = "gagal";
        if(id.equals("sukses")){
             status = "sukses";
        }else{ status = "gagal"; }
        
        return status;
    }

}
