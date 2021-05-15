package com.devemg.ShopList.dao;

import com.devemg.ShopList.entities.Product;
import static com.devemg.data.MysqlConnection.*;
import java.sql.*;
import java.util.*;

public class ProductDAO {
    // Define SQL sentences
    private static final String SQL_SELECT = "SELECT id, name, budget, quantity, image, description FROM product";
    private static final String SQL_SELECT_ONE = "SELECT id, name, budget, quantity, image, description FROM product WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO product(name, budget, quantity, image, description) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE product SET name=?,budget=?,quantity=?,image=?, description=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM product WHERE id = ?";

   public List<Product> selectAll(){
       Connection conn = null;
       PreparedStatement pStatement = null;
       ResultSet rs = null;
       List<Product> products = new ArrayList<>();

       try {
           conn = getConnection();
           pStatement = conn.prepareStatement(SQL_SELECT);
           rs = pStatement.executeQuery();
           while (rs.next()){
               products.add(new Product(
                       rs.getInt("id"),
                       rs.getString("name"),
                       rs.getDouble("budget"),
                       rs.getInt("quantity"),
                       rs.getString("image"),
                       rs.getString("description")
               ));
           }


       }catch (SQLException ex){
           ex.printStackTrace(System.err);
       }
       finally {
           try {
               close(rs);
               close(pStatement);
               close(conn);
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }

       }
    return products;
   }

    public Product select(int idProduct){
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_SELECT_ONE);
            pStatement.setInt(1,idProduct);
            rs = pStatement.executeQuery();
            while (rs.next()){
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("budget"),
                        rs.getInt("quantity"),
                        rs.getString("image"),
                        rs.getString("description")
                );
            }


        }catch (SQLException ex){
            ex.printStackTrace(System.err);
        }
        finally {
            try {
                close(rs);
                close(pStatement);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return product;
    }

    public int insert(Product product){
       // vaidate name
        if(product.getName() == null) {
            return 0;
        }
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_INSERT);
            pStatement.setString(1,product.getName());
            pStatement.setDouble(2,product.getBudget());
            pStatement.setInt(3,product.getQuantity());
            pStatement.setString(4,product.getImage());
            pStatement.setString(5,product.getDescription());
            result = pStatement.executeUpdate();
            
        }catch (SQLException ex){
            ex.printStackTrace(System.err);
        }
        finally {
            try {
                close(pStatement);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

    public int update(int idProduct,Product product){
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_UPDATE);
            pStatement.setString(1,product.getName());
            pStatement.setDouble(2,product.getBudget());
            pStatement.setInt(3,product.getQuantity());
            pStatement.setString(4,product.getImage());
            pStatement.setString(5,product.getDescription());
            pStatement.setInt(6,idProduct);
            result = pStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace(System.err);
        }
        finally {
            try {
                close(pStatement);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

    public int delete(int idProduct){
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_DELETE);
            pStatement.setInt(1,idProduct);
            result = pStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace(System.err);
        }
        finally {
            try {
                close(pStatement);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

}
