package com.devemg.data.dao;

import com.devemg.data.entities.Product;

import java.util.List;

public interface ProductDAO {

    public int insert(Product product);
    public int update(Product product);
    public int delete(int idProduct);
    public Product select(int idProduct);
    public List<Product> select();

}
