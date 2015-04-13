package belajar.nfc.service;

import belajar.nfc.domain.Customer;
import belajar.nfc.domain.Saldo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mohamad
 */
@Repository
public interface SaldoDao extends CrudRepository<Saldo, String> {
    Saldo findSaldoByCustomerAndTanggal(Customer customer, Date date);
}

