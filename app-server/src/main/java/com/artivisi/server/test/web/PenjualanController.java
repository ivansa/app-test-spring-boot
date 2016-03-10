/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.server.test.web;

import com.artivisi.server.test.dao.PenjualanDao;
import com.artivisi.server.test.domain.Penjualan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ivans
 */
@RestController
@RequestMapping("/api/transaksi/penjualan")
public class PenjualanController {
    @Autowired
    private PenjualanDao penjualanDao;
    
    @RequestMapping("/list")
    public Iterable<Penjualan> allProduct() {
        Iterable<Penjualan> result = penjualanDao.findAll();
        return result;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Penjualan penjualan) {

        penjualanDao.save(penjualan);
    }
}
