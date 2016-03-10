/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.server.test.dao;

import com.artivisi.server.test.domain.Penjualan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivans
 */
@Repository
public interface PenjualanDao extends PagingAndSortingRepository<Penjualan, String>{
    
}
