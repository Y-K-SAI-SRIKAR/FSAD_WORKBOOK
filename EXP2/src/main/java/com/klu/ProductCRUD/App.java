package com.klu.ProductCRUD;

import java.util.List;

import com.klu.dao.ProductDao;
import com.klu.entity.Products;

public class App {

    public static void main(String[] args) {

        ProductDao dao = new ProductDao();

        // INSERT
        Products p1 = new Products(0, "Mobile", 10, 70000);
        Products p2 = new Products(0, "Ipad", 50, 200000);
        dao.saveProduct(p1);
        dao.saveProduct(p2);

        // READ BY ID
        Products p = dao.getId(1);

        // UPDATE
        if (p != null) {
            p.setPrice(60000);
            dao.updateProduct(p);
        }

        // DELETE
        dao.deleteProduct(3);

        // PRINT ALL PRODUCTS (FINAL OUTPUT)
        List<Products> list = dao.getAllProducts();
        for (Products prod : list) {
            System.out.println(prod);
        }
    }
}