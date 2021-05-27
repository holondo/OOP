/**
 * This class is designed to simulate a set of rolling dice. 
 * Developed for OOP class.
 * @author Holondo
 */
public class RolaDados {

    private Dado[] dice;
    private int diceAmnt;

     /**
	 * Inicializes the n dice of the set.
	 * @param n Number of dice.
	 */
    public RolaDados(int n)
    {
        dice = new Dado[n+1];
        for(int i = 1; i <= n; i++)
        {
            dice[i] = new Dado();
        }

        diceAmnt = n;
    }

    /**
	 * Rolls the specified dice.
	 * @param boolean[] quais; (Which dice)
     * @return (int[]) The resultant set of showing sides.
	 */
    public int[] rolar(boolean[] quais)
    {
        int[] result = new int[diceAmnt];

        for (int i = 0; i < result.length; i++) {

            if(quais[i]) dice[i+1].rolar();

            result[i] = dice[i+1].getLado();
        }

        return result;
    }

    /**
	 *  Rolls the specified dice.
	 * @param String s; (Dice enumerators [1 - (dice amount)])
     * @return (int[]) The resultant set of showing sides.
     **/
    public int[] rolar(String s)//vetor bool quais 0...
    {
        boolean[] quais = new boolean[diceAmnt];

        for (int i = 0; i < diceAmnt; i++)
        {
            quais[i] = s.contains( ("" + (i+1)) );
        }
        return rolar(quais);
    }

    /**
	 * Rolls every die in the set.
     * @return ( int[] ) The resultant set of showing sides.
	 */
    public int[] rolar()
    {
        boolean[] quais = new boolean[diceAmnt];
        for (int i = 0; i < quais.length; i++) {
            quais[i] = true;
        }

        return rolar(quais);
    }
    
    /**
	* Returns the formatted ASCII Art of the top of the set of dice.
    * @return (String) Formatted ASCII Art.
    */
    @Override
    public String toString()
    {
        String view = new String("");
        String dieIndex = new String("");
        String[] aux;

        for (int i = 1; i <= diceAmnt; i++)
        {
            dieIndex += (i) + "\t";
            view += dice[i].toString();
        }
        dieIndex += '\n';

        aux = view.split("\n");
        view = "";

        for (int i = 0; i < 5; i++) //5 is the number of lines in the ASCII Art
        {
            for (int j = i; j < (5 * diceAmnt); j += 5)//It jumps 5 lines to the next die's correspondent
            {
                view += aux[j] + '\t';
            }

            view += '\n';
        }

        return dieIndex + view;
    }
}
