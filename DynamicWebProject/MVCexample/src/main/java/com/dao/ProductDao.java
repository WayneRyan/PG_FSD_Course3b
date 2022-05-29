package com.dao;

import com.bean.Product;
import com.resource.DbResource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public int storeProduct(Product product) {
        try {
            Connection con = DbResource.getDbConnection();
            PreparedStatement pstmt = con.prepareStatement("insert into product (pid, pname, price) values (?,?,?)");
            pstmt.setInt(1,product.getPid());
            pstmt.setString(2, product.getPname());
            pstmt.setFloat(3, product.getPrice());
            int res = pstmt.executeUpdate();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public List<Product> getAllProductDetails() {
        List<Product> listOfProduct = new ArrayList<>();
        try {
            Connection con = DbResource.getDbConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from product");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt(1));
                p.setPname(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                listOfProduct.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listOfProduct;
    }

}
