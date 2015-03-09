/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.nfc.service;

import belajar.nfc.domain.EntriTransaksi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author renaldy
 */
@Repository
public interface EntriTransaksiDao extends CrudRepository<EntriTransaksi, String>{

    
}
