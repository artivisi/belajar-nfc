/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.nfc.Controller;

import belajar.nfc.domain.EntriTransaksi;
import belajar.nfc.service.EntriTransaksiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author renaldy
 */
@RestController
 @RequestMapping("/api")
public class EntriTransaksiController {
    
    @Autowired
    private EntriTransaksiDao entriTransaksiDao;
    
    @RequestMapping(value = "/entriTransaksi" , method = RequestMethod.GET)
    public Iterable<EntriTransaksi> findAllEntriTransaksi() {
        return entriTransaksiDao.findAll();
    }
    
    @RequestMapping(value = "/entriTransaksi/{id}", method = RequestMethod.DELETE)
    public void deleteEntriTransaksi(@PathVariable(value = "id")String id) throws Exception {
        if (id == null) {
            throw new Exception("id tidak ada");
        }
        
        EntriTransaksi entriTransaksi = entriTransaksiDao.findOne(id);
        
        if (entriTransaksi == null) {
            throw new Exception("Data tidak ditemukan");
        }
        
        entriTransaksiDao.delete(entriTransaksi);
    }
    
    @RequestMapping(value = "/entriTransaksi", method = RequestMethod.POST)
    public void saveEntriTransaksi(@RequestBody EntriTransaksi entriTransaksi) throws Exception{
        if (entriTransaksi == null) {
            throw new Exception("Tidak Boleh Kosong");
        }
        entriTransaksiDao.save(entriTransaksi);
    }
    
    
}
