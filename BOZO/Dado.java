/**
 * This class is designed to simulate a rolling die
 * Developed for OOP class
 * @author Holondo
 */
public class Dado {

    private int facesAmnt; //Number of sides
    private int facingUp; //Which side is facing up
    private Random die; //Random numbers object

    /**
	 * Inicializes the die with a random seed and 
     * the deafault number of sides (6).
	 */
    public Dado()
    {
        facesAmnt = 6;
        facingUp = 1;
        for (Long i = 0l; i < 1000000; i++) {}
        die = new Random();
    }

    /**
	 * Inicializes the die with a random seed and 
     * a specified number od sides.
	 * @param n Number of sides.
	 */
    public Dado(int n)
    {
        facesAmnt = n;
        facingUp = 1;
        die = new Random();
    }

    /**
	 * Simulates a die's roll.
	 * @return (int) The side that is facing up.
	 */
    public int rolar()
    {
        facingUp = die.getIntRand(facesAmnt) + 1;
        
        return facingUp;
    }

    /**
	 * Returns the top side of the die.
	 * @return (int) The side that is facing up.
	 */
    public int getLado()
    {
        return facingUp;
    }

    /**
	 * Returns the formatted ASCII Art of the top of the die.
	 * @return (String) Formatted ASCII Art.
	 */
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
