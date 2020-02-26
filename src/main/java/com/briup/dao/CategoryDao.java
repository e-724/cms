package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Category;
import com.briup.bean.Customer;

public interface CategoryDao  extends JpaRepository<Category, Integer>{

}
