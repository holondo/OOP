/**
 * This class is designed to simulate a rolling die
 * Developed for OOP class
 * @author Holondo
 *
 */
public class Dado {

    private int facesAmnt;
    private int facingUp;
    private Random die;


    public Dado()
    {
        facesAmnt = 6;
        facingUp = 1;
        for (Long i = 0l; i < 1000000; i++) {}
        die = new Random();
    }
    
    public Dado(int n)
    {
        facesAmnt = n;
        facingUp = 1;
        die = new Random();
    }

    public int rolar()
    {
        
        facingUp = die.getIntRand(facesAmnt) + 1;
        
        return facingUp;
    }

    public int getLado()
    {
        return facingUp;
    }

    @Override
    public String toString()
    {
        String toReturn = "+-----+\n";

        if(facingUp > 3) toReturn += "|*   *|\n";
        else if(facingUp == 1) toReturn += "|     |\n";
        else toReturn += "|    *|\n";

        if(facingUp == 6)   toReturn += "|*   *|\n";
        else if((facingUp % 2) == 0) toReturn += "|     |\n";
        else toReturn += "|  *  |\n";

        if(facingUp > 3) toReturn += "|*   *|\n";
        else if(facingUp == 1) toReturn += "|     |\n";
        else toReturn += "|*    |\n";

        toReturn += "+-----+\n";

        return toReturn;
    }
}
