public class Rectangle extends GeometricFigure{
    double base, height;

    public Rectangle(Double base, double height, String color, boolean filled)
    {
        super(color, filled);
        setBase(base);
        setHeight(height);
    }

    public void setBase(double base) {
        this.base = base;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getPerimeter()
    {
        return (this.base * 2) + (this.height * 2);
    }

    @Override
    public double getArea()
    {
        return (this.base * this.height);
    }

    @Override
    public String toString()
    {
        String toReturn = "";
        if(this.base == this.height)
            toReturn += "\nQuadrado:\nLado = " + this.base;
        else
            toReturn += "\nRetângulo:\nBase = " + this.base + "altura = " + this.height;
        toReturn += "\nCor = " + this.color;
        toReturn += "\nPreenchido = " + (this.isFilled() ? "Sim" : "Não"); 
        toReturn += "\nPerímetro = " + this.getPerimeter();
        toReturn += "\nÁrea = " + this.getArea();
        toReturn += "\n\t***\n";  
        return toReturn;      
    }
}
