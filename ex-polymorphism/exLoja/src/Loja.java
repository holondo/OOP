import java.util.ArrayList;
public class Loja {

    ArrayList<Product> products = new ArrayList<Product>();
    
    public void addProduct(Product product)
    {
        this.products.add(product);
    }

    public void addStock(String strQuery, int amnt) throws Exception
    {
        int which = sequencialSearch(strQuery);
        if(which != -1)
        {
            this.products.get(which).setInStock(this.products.get(which).getInStock() + amnt);
        }
        else
        {
            throw new Exception("Produto não localizado. Cadatre-o primeiro.");
        }
    }

    public void sell(String strQuery, int amnt) throws Exception
    {
        int which = sequencialSearch(strQuery);
        if(which != -1)
        {
            if(this.products.get(which).getInStock() - amnt < 0)
                throw new Exception("Quantidade de produtos acima do estoque.");
            else    
                this.products.get(which).setInStock(this.products.get(which).getInStock() - amnt);
        }
        else
        {
            throw new Exception("Produto não localizado. Cadatre-o primeiro.");
        }
    }

    public Product searchProduct(String strQuery) throws Exception
    {
        int found = sequencialSearch(strQuery);
        System.out.println("\naaa:" +found);
        if(found == -1) throw new Exception("Produto não encontrado!");

        return this.products.get(found);
    }

    private int sequencialSearch(String strQuery)
    {
        int toReturn = -1;
        for(int i = 0; i < this.products.size(); i++)
        {
            if( strQuery.equals(this.products.get(i).getName()) || strQuery.equals(this.products.get(i).getBarCode()))
            {
                toReturn = i;
            }
        }
        return toReturn;
    }

    @Override
    public String toString()
    {
        CD aux1 = new CD();
        DVD aux2 = new DVD();
        Book aux3 = new Book();
        int c1 = 0,c2 = 0,c3 = 0;
        String toReturn = "";

        for (Product product : products) {
            toReturn += "\nProduto: " + product.getName() + "\t-\tQuantidade: " + product.getInStock();
            if(product.getClass() == aux1.getClass())
                c1++;
            
            else if(product.getClass() == aux2.getClass())
                c2++;
            
            else if(product.getClass() == aux3.getClass())
                c3++;            
        }

        toReturn += "\n\t***";
        toReturn += "\nCDs : " + c1 + " produtos.";
        toReturn += "\nDVDs : " + c2 + " produtos.";
        toReturn += "\nLivros : " + c3 + " produtos."; 

        return toReturn;
    }
}
