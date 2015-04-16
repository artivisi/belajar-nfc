/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.nfc.service;

import belajar.nfc.domain.EntriTransaksi;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author renaldy
 */
@Repository
public interface EntriTransaksiDao extends CrudRepository<EntriTransaksi, String>{

  @Query("SELECT u FROM EntriTransaksi u WHERE tanggal >=  :startdate AND tanggal <=  :enddate")
  Iterable<EntriTransaksi> findByStartDateAndEndDate(@Param("startdate") Date startdate, @Param("enddate") Date enddate);
    
}
