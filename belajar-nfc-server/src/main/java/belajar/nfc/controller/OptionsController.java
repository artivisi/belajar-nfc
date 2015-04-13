/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajar.nfc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author adi
 */

public class OptionsController {
    private final Logger LOGGER = LoggerFactory.getLogger(OptionsController.class);
    
    @RequestMapping(value="/{id}", method = RequestMethod.OPTIONS)
    public void handleOptionsUserWithId(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        String host = request.getHeader("Host");
        String origin = request.getHeader("Origin");
        LOGGER.info("Options Controller URI [{}] method [{}] headers [{}] ipserver [{}]", 
                new Object[]{request.getRequestURI(), request.getMethod(), origin, host});
    }
    
    @RequestMapping(method = RequestMethod.OPTIONS)
    public void handleOptionsUser(HttpServletRequest request, HttpServletResponse response){
        String host = request.getHeader("Host");
        String origin = request.getHeader("Origin");
        LOGGER.info("Options Controller URI [{}] method [{}] headers [{}] ipserver [{}]", 
                new Object[]{request.getRequestURI(), request.getMethod(), origin, host});
    }
    
}
