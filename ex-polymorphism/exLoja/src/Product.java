public class Product {
    String barCode;
    String name;
    Double price;
    int inStock;

    public Product(String name, double price, String barCode)
    {
        setBarcode(barCode);
        setName(name);
        setPrice(price);
        setInStock(0);
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public void setInStock(int inStock)
    {
        this.inStock = inStock;
    }

    public String getName() {
        return this.name;
    }

    public String getBarCode()
    {
        return this.barCode;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getInStock() {
        return this.inStock;
    }

    @Override
    public String toString()
    {
        String toReturn = "\nNome: " + getName();
        toReturn += "\nCódigo de barras: " + getBarCode();
        toReturn += "\n\t===\n";
        return toReturn;
    }
}
