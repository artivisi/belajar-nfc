package belajar.nfc.controller;

import belajar.nfc.domain.Customer;
import belajar.nfc.domain.EntriTransaksi;
import belajar.nfc.domain.Saldo;
import belajar.nfc.service.EntriTransaksiDao;
import belajar.nfc.service.SaldoDao;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;


/**
 *
 * @author mohamad
 */
@RestController
@RequestMapping("/api/bayar")
public class PembayaranController extends OptionsController {

    @Autowired
    private SaldoDao saldoDao;
    
    @Autowired
    private EntriTransaksiDao entriTransaksiDao;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Saldo> findAllSaldo() {
        return saldoDao.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Saldo findOne(@PathVariable(value = "id") String id) {
        return saldoDao.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void bayarTagihan(@PathVariable String id) throws Exception {
        EntriTransaksi entriTransaksi = entriTransaksiDao.findOne(id);
        Saldo saldo = saldoDao.findSaldoByCustomerAndTanggal(entriTransaksi.getCustomer(), new Date());
        if(saldo != null){
            saldo.setMutasiKredit(saldo.getMutasiKredit().add(entriTransaksi.getNilaiTransaksi()));
            saldoDao.save(saldo);
        }
        else if(saldo == null) {
            Saldo newSaldo = new Saldo();
            newSaldo.setTanggal(new Date());
            newSaldo.setSaldoAwal(hitungSaldoAkhir(entriTransaksi.getCustomer()));
            newSaldo.setMutasiDebet(BigDecimal.ZERO);
            newSaldo.setMutasiKredit(entriTransaksi.getNilaiTransaksi());
            newSaldo.setCustomer(entriTransaksi.getCustomer());
            saldoDao.save(newSaldo);
        }
        else { throw new Exception("Gagal menyimpan/merubah saldo"); }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTagihan(@PathVariable(value = "id") String id) throws Exception {
        Saldo saldo = saldoDao.findOne(id);
        if (saldo == null)
            throw new Exception("Data tidak ditemukan");
        else
        saldoDao.delete(saldo);
    }
    
    public BigDecimal hitungSaldoAkhir(Customer customer)throws Exception {
        Instant kemarin = Instant.now().minus(1, ChronoUnit.DAYS);
        
        Saldo saldoAkhir = saldoDao.findSaldoByCustomerAndTanggal(customer, new Date(kemarin.toEpochMilli()));
        
        BigDecimal result = BigDecimal.ZERO;
        if(saldoAkhir != null){
            result = saldoAkhir.getSaldoAwal().add(saldoAkhir.getMutasiDebet()).subtract(saldoAkhir.getMutasiKredit());
        }
        
        return result;
    }
}
