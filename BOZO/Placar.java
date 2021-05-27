/**
 * This class is designed to simulate a Scoreboard
 * for the BOZO game. 
 * Developed for OOP class.
 * @author Holondo
 */
public class Placar {

    private int[] slots;
    private boolean[] commited;

    /**
	 *  Inicializes the Scoreboard.
	 */
    public Placar()
    {
        slots = new int[10];
        commited = new boolean[10];
    }
    
    /**
	 *  Adds a number of points made by a
     * set of dice in a free slot of the Scoreboard. 
	 * @param int posicao; (Slot number)
     * @param int[] dados; (Array of rolled dice)
	 */
    public void add(int posicao, int[] dados)
    throws java.lang.IllegalArgumentException
    {
        if(posicao > 10 || posicao < 1 || commited[posicao - 1])
            throw new IllegalArgumentException( (commited[posicao - 1]) ? "Occupied position\n" : "Invalid position\n");

        int[] counter = new int[6];
        int sequenceVerifier = 0;

        for (int i : dados) // Add +1 to each found die's counter
        {
            counter[i - 1]++;
        }

        if(posicao <= 6)
        {
            slots[posicao - 1] = counter[posicao - 1] * posicao;
            commited[posicao - 1] = true;
        }

        else
        {
            switch(posicao)
            {
                case 7: //Full Hand (3 or more dice)
                    for (int i : counter)
                    {
                        if(i >= 3) slots[posicao - 1] = 15;
                        commited[posicao - 1] = true;
                    }
                    break;

                case 8: //Sequence (1-5 or 2-)
                    for (int i : counter)
                    {
                        if(i == 1) sequenceVerifier += i; //If it's a sequence, it's supposed to have only one face of which
                    }

                    if(sequenceVerifier == 5) 
                    {
                        slots[posicao - 1] = 20;
                        commited[posicao - 1] = true;
                    }
                    break;

                case 9: //Quadra (4 or more dice)
                    for (int i : counter)
                    {
                        if(i >= 4) slots[posicao - 1] = 30;
                        commited[posicao - 1] = true;
                    }
                    break;
                
                case 10: //Quina (5 dice)
                    for (int i : counter)
                    {
                        if(i == 5) slots[posicao - 1] = 40;
                        commited[posicao - 1] = true;
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
	 * Returns the score.
     * @return (int) total (score)
	 */
    public int getScore()
    {
        int total = 0;

        for (int i = 0; i < slots.length; i++)
        {
            if(commited[i]) total += slots[i];    
        }

        return total;
    }

    /**
	* Returns the formatted ASCII Art of the Scoreboard.
    * @return (String) Formatted ASCII Art.
     */
    @Override
	public String toString()
    {
		String show = "";
		String[] formattedScore = new String[10];

		for(int i = 0; i< 10; i++)
        {
			if(commited[i]) formattedScore[i] = "=> " + slots[i];
			else
            {
				formattedScore[i] = "(" + (i+1) + ")";
			}
		}

		show += formattedScore[0] + "\t|\t" + formattedScore[6] + "\t|\t" + formattedScore[3] + "\n";
		show += "-------------------------------------\n";
		show += formattedScore[1] + "\t|\t" + formattedScore[7] + "\t|\t" + formattedScore[4] + "\n";
		show += "-------------------------------------\n";
		show += formattedScore[2] + "\t|\t" + formattedScore[8] + "\t|\t" + formattedScore[5] + "\n";
		show += "-------------------------------------\n";
		show += "\t|\t" + formattedScore[9] + "\t|\t\n";
		show += "\t+---------------+\t\n";
		      
		return show;
	}
}