/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.server.test.web;

import com.artivisi.server.test.dao.CategoryDao;
import com.artivisi.server.test.domain.Category;
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
@RequestMapping("/api/master/category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("/list")
    public Iterable<Category> allCategory() {
        Iterable<Category> result = categoryDao.findAll();
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category findCategoryById(@PathVariable String id) {
        Category c = categoryDao.findOne(id);

        if (c == null) {
            return null;
        }

        return c;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        Category c = categoryDao.findOne(id);
        if (c != null) {
            categoryDao.delete(id);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Category category) {

        categoryDao.save(category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id, @RequestBody Category category) throws Exception {
        Category p = categoryDao.findOne(id);
        if (p != null) {
            category.setId(p.getId());
            categoryDao.save(category);
        }
    }
}
