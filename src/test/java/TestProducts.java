import com.devemg.data.dao.ProductDAO;
import com.devemg.data.entities.Product;

import java.util.List;

public class TestProducts {
    public static void main(String[] args) {
        ProductDAO productDao = new ProductDAO();

        //create
        int result = productDao.insert(new Product("Fideos", 3, 10,"Paquete de fideos"));
        System.out.println(result>0?"INSERTADO":"NO INSERTADO");

        //select all
        List<Product> products = productDao.selectAll();
        products.forEach(System.out::println);
        int total = products.size();
        //select one
        Product prod = productDao.select(total);
        // update
        prod.setprice(15);
        prod.setDescription("Prueba de actualización");
        productDao.update(prod);
        prod = productDao.select(total);
        System.out.println(prod);
        productDao.insert(new Product("Fideos", 3, 10,"Paquete de fideos"));
        total++;
        productDao.delete(total);
        System.out.println("SELECT ALL -------------------------------------------");
        products = productDao.selectAll();
        products.forEach(System.out::println);

    }
}
