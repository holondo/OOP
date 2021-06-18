public class Circle extends GeometricFigure{

    double radius;

    public Circle(double radius, String color, boolean filled)
    {
        super(color, filled);
        setRadius(radius);
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getPerimeter()
    {
        return 2 * (Math.PI * this.radius);
    }

    @Override
    public double getArea()
    {
        return (Math.PI * (Math.pow(this.radius, 2.0)));
    }

    @Override
    public String toString()
    {
        String toReturn = "\nCírculo:";
        toReturn += "\nRaio = " + this.radius;
        toReturn += "\nCor = " + this.color;
        toReturn += "\nPreenchido = " + (this.isFilled() ? "Sim" : "Não"); 
        toReturn += "\nPerímetro = " + this.getPerimeter();
        toReturn += "\nÁrea = " + this.getArea();
        toReturn += "\n\t***\n";  
        return toReturn;
    }
}
