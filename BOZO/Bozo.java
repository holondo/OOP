public class Bozo{
    public static int DICEAMNT = 5;
    public static void main(String[] args)
    {
        RolaDados diceBoard = new RolaDados(DICEAMNT);
        Placar scoreBoard = new Placar();
        String opt;
        int slotSelector;

        for (int i = 0; i < 2; i++)
        {
            slotSelector = 0;
            opt = "notpressed";
            
            System.out.println(scoreBoard.toString());

            System.out.println("Rodada " + (i+1) + "\nPressione ENTER para jogar os dados.\n");
            
            while(!opt.equals("")) //Waits for ENTER
            {
                try
                {
                    opt = EntradaTeclado.leString();    
                }catch (Exception e)
                {
                    continue;
                }
            }
            
            diceBoard.rolar();
            System.out.println(diceBoard.toString());

            for (int j = 0; j < 2; j++)
            {
                System.out.println("Digite o numero dos dados que quiser TROCAR. Separados por espaço.\n");

                try
                {
                    diceBoard.rolar(EntradaTeclado.leString());
                    System.out.println(diceBoard.toString());
                }
                catch(Exception E)
                {
                    diceBoard.rolar("");
                    System.out.println(diceBoard.toString());
                }                
            }

            while (slotSelector == 0)
            {
                System.out.println("Escolha a posição que quer ocupar com essa jogada ==>");
                try
                {
                    slotSelector = EntradaTeclado.leInt();    
                } catch (Exception e)
                {
                    System.out.println("Digite o numero da posição de 1 a 10.");
                } 
            }

            scoreBoard.add(slotSelector, diceBoard.rolar(""));
        }
        
        System.out.println("Seu score final foi: " + scoreBoard.getScore());
    }    
}
