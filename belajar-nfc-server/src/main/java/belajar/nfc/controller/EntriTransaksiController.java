/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.nfc.controller;

import belajar.nfc.domain.EntriTransaksi;
import belajar.nfc.helper.DateHelper;
import belajar.nfc.service.EntriTransaksiDao;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.Instant;

/**
 *
 * @author renaldy
 */
@RestController
@RequestMapping("/api/entriTransaksi")
public class EntriTransaksiController extends OptionsController {

    @Autowired
    private EntriTransaksiDao entriTransaksiDao;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<EntriTransaksi> findAllEntriTransaksi() {
        return entriTransaksiDao.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EntriTransaksi findOne(@PathVariable(value = "id") String id) {
        return entriTransaksiDao.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteEntriTransaksi(@PathVariable(value = "id") String id) throws Exception {
        if (id == null) {
            throw new Exception("id tidak ada");
        }

        EntriTransaksi entriTransaksi = entriTransaksiDao.findOne(id);

        if (entriTransaksi == null) {
            throw new Exception("Data tidak ditemukan");
        }

        entriTransaksiDao.delete(entriTransaksi);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveEntriTransaksi(@RequestBody EntriTransaksi entriTransaksi) throws Exception {
        if (entriTransaksi == null) {
            throw new Exception("Tidak Boleh Kosong");
        }
        entriTransaksi.setLunas(Boolean.FALSE);
        entriTransaksiDao.save(entriTransaksi);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public void updateEntriTransaksi(@RequestBody EntriTransaksi entriTransaksi) throws Exception {
        if (entriTransaksi == null) {
            throw new Exception("Tidak Boleh Kosong");
        }
        entriTransaksiDao.save(entriTransaksi);
    }
    
    @RequestMapping(value = "/laporan", method = RequestMethod.GET)
    public Iterable<EntriTransaksi> findStartdateAndEnddate(
        @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("sdate") Date sdate,
        @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("edate") Date edate) throws Exception {
        
        return entriTransaksiDao.findByStartDateAndEndDate(DateHelper.dateWithMinTime(sdate), DateHelper.dateWithMaxTime(edate));
    }
}
