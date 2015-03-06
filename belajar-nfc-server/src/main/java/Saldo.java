
import belajar.nfc.domain.Customer;
import com.sun.istack.internal.Nullable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andikha
 */
@Entity
@Table(name = "saldo")
public class Saldo {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    @Column(nullable= false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date tanggal;
    
    @NotNull
    @Column(nullable = false)
    private BigDecimal saldoAwal;
    
    @NotNull
    @Column(nullable = false)
    private BigDecimal mutasiDebet;
            
    @NotNull
    @Column(nullable = false)
    private BigDecimal mutasiKredit;
    
    @ManyToOne
    @NotNull
    @JoinColumn(nullable = false, name = "id_customer")
    private Customer customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public BigDecimal getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoAwal(BigDecimal saldoAwal) {
        this.saldoAwal = saldoAwal;
    }

    public BigDecimal getMutasiDebet() {
        return mutasiDebet;
    }

    public void setMutasiDebet(BigDecimal mutasiDebet) {
        this.mutasiDebet = mutasiDebet;
    }

    public BigDecimal getMutasiKredit() {
        return mutasiKredit;
    }

    public void setMutasiKredit(BigDecimal mutasiKredit) {
        this.mutasiKredit = mutasiKredit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
}

