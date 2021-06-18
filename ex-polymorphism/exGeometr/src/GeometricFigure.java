public class GeometricFigure {
    String color;
    boolean filled;

    public GeometricFigure()
    {
        setColor("white", false);
    }

    public GeometricFigure(String color, boolean filled)
    {
        setColor(color, filled);
    }
    public void setColor(String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public boolean isFilled()
    {
        return this.filled;
    }

    public double getPerimeter() throws Exception
    {
        throw new Exception("Não é possivel calcular o perimetro de figura não definida.");
    }

    public double getArea() throws Exception
    {
        throw new Exception("Não é possivel calcular a área de figura não definida.");
    }    
}
