/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.server.test.web;

import com.artivisi.server.test.dao.ProductDao;
import com.artivisi.server.test.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ivans
 */
@RestController
@RequestMapping("/api/master/product")
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @RequestMapping("/list")
    public Iterable<Product> allProduct() {
        Iterable<Product> result = productDao.findAll();
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findProductById(@PathVariable String id) {
        Product p = productDao.findOne(id);

        if (p == null) {
            return null;
        }

        return p;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        Product p = productDao.findOne(id);
        if (p != null) {
            productDao.delete(id);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Product product) {

        productDao.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id, @RequestBody Product product) throws Exception {
        Product p = productDao.findOne(id);
        if (p != null) {
            product.setId(p.getId());
            productDao.save(product);
        }
    }
}
