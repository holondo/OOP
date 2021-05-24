public class RolaDados {

    private Dado[] dice;
    private int diceAmnt;

    public RolaDados(int n)
    {
        dice = new Dado[n+1];
        for(int i = 1; i <= n; i++)
        {
            dice[i] = new Dado();
        }

        diceAmnt = n;
    }

    public int[] rolar(boolean[] quais)
    {
        int[] result = new int[diceAmnt];

        for (int i = 0; i < result.length; i++) {

            if(quais[i]) dice[i+1].rolar();

            result[i] = dice[i+1].getLado();
        }

        return result;
    }

    public int[] rolar(String s)
    {
        boolean[] quais = new boolean[diceAmnt];

        for (int i = 0; i < diceAmnt; i++)
        {
            quais[i] = s.contains("" + (i+1));
        }
        return rolar(quais);
    }

    public int[] rolar()
    {
        boolean[] quais = new boolean[diceAmnt];
        for (int i = 0; i < quais.length; i++) {
            quais[i] = true;
        }

        return rolar(quais);
    }
    
    @Override
    public String toString()
    {
        String view = new String();
        for (int i = 1; i <= diceAmnt; i++)
        {
            view += dice[i].toString();    
        }

        return view;
    }

    public static void main(String[] args) {
        RolaDados teste = new RolaDados(5);

        teste.rolar();
        System.out.println(teste.toString());

    }
}
