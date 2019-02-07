/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.CategoryRepository;
import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    public Category saveCategory(Category category){
        return repository.save(category);
    }
    
    public Category findCategory(Long idCategory) throws EntityNotFoundException {
        Category user= repository.findById(idCategory).orElse(null);
        if(user==null){
            throw new EntityNotFoundException(Category.class,"id",idCategory.toString());
        }       
        return user;
    }
    
     public void deleteCategory(Long idCategory) throws EntityNotFoundException {
        Category category= repository.findById(idCategory).orElse(null);
        if(category==null){
            throw new EntityNotFoundException(Category.class,"id",idCategory.toString());
        }
        repository.delete(category);        
    }
     
       public Category updateCategory(Category category, Long idCategory) throws EntityNotFoundException {
        Category u= repository.findById(idCategory).orElse(null);
        if(u==null){
            throw new EntityNotFoundException(Category.class,"id",idCategory.toString());
        }
        //repository.delete(u);  
        category.setId(idCategory);
        return repository.save(category);
    }
       public List<Category> getAllUsers() {
       
        return (List<Category>)repository.findAll();
    }
}//endclass
