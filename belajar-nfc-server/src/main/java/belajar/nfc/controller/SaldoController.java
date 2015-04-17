package belajar.nfc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mohamad
 */
@RestController
@RequestMapping("/api/saldo")
public class SaldoController extends OptionsController {

    @RequestMapping(method = RequestMethod.GET)
    public String cekSaldo() {
        return "Sisa Saldo : Rp.1.000.000,00";
    }
    
}