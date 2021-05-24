import java.lang.reflect.Array;

public class Placar {

    private int[] slots;
    private boolean[] commited;

    public Placar()
    {
        slots = new int[9];
        commited = new boolean[9];
    }
    
    public void add(int posicao, int[] dados)
    throws java.lang.IllegalArgumentException
    {
        if(posicao > 10 || posicao < 1 || commited[posicao])
            throw new IllegalArgumentException( (commited[posicao] ? "Occupied position" : "Invalid position"));

        int[] counter = new int[6];
        int sequenceVerifier = 0;

        for (int i : dados)
        {
            counter[i - 1]++;    
        }

        if(posicao <= 6)
        {
            /*for (int i = 0; i < dados.length; i++)
            {
                if(dados[i] == posicao)
                    slots[posicao - 1] += dados[i];
            }*/

            slots[posicao - 1] = counter[posicao - 1] * posicao; //verificar
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
    //ToDo: implementar os outros metodos e verificar se add(esta funcionando
}
