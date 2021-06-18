import java.util.ArrayList;
public class Loja {

    ArrayList<Product> products = new ArrayList<Product>();
    private int[] productsAmnt;
    
    public void addProduct(Product product)
    {
        this.products.add(product);
    }

    public void addStock(String strQuery, int amnt)
    {
        int which = sequencialSearch(strQuery);
        if(which != -1)
        {
            this.products[which].setInStock(this.products[which].getStock() + amnt);
        }
        else
        {
            this.addProduct(product);
        }
    }

    private int sequencialSearch(String strQuery)
    {
        for (Product product : products) {
            if(product.getBarCode() == strQuery || product.getName() == strQuery)
            {
                return pr
            }
        }
    }
}
