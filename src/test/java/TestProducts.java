import com.devemg.data.JDBC.ProductJDBC;
import com.devemg.data.dao.ProductDAO;
import com.devemg.data.entities.Product;

import java.sql.SQLException;
import java.util.List;

public class TestProducts {
    public static void main(String[] args) {
        try {
            ProductDAO productJDBC = new ProductJDBC();

            //create
            int result = productJDBC.insert(new Product("Fideos", 3, 10,"Paquete de fideos"));
            System.out.println(result>0?"INSERTADO":"NO INSERTADO");

            //select all
            List<Product> products = productJDBC.select();
            products.forEach(System.out::println);
            int total = products.size();
            //select one
            Product prod = productJDBC.select(total);
            // update
            prod.setprice(15);
            prod.setDescription("Prueba de actualización");
            productJDBC.update(prod);
            prod = productJDBC.select(total);
            System.out.println(prod);
            productJDBC.insert(new Product("Fideos", 3, 10,"Paquete de fideos"));
            total++;
            productJDBC.delete(total);
            System.out.println("SELECT ALL -------------------------------------------");
            products = productJDBC.select();
            products.forEach(System.out::println);
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

    }
}
