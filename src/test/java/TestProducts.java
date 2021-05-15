import com.devemg.ShopList.dao.ProductDAO;
import com.devemg.ShopList.entities.Product;

import java.util.List;

public class TestProducts {
    public static void main(String[] args) {
        ProductDAO productDao = new ProductDAO();

       // int result = productDao.insert(new Product("Fideos", 3, 10,"url","Paquete de fideos"));
        //System.out.println(result>0?"INSERTADO":"NO INSERTADO");
        //List<Product> products = productDao.selectAll();
        //products.forEach(System.out::println);
        Product prod = productDao.select(7);
        System.out.println(prod);
        prod.setBudget(15);
        prod.setDescription("Prueba de actualización");
        productDao.update(prod);
        prod = productDao.select(7);
        System.out.println(prod);
    }
}
