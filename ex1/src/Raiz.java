
public class Raiz{

    public static void main(String[] args) {
        
        double x, xi, xi1, diff;

        while (true) {

            try {
                System.out.println("Digite um numero X:");
                x = EntradaTeclado.leDouble();
                
                System.out.println("Agora chute um valor para raiz de X.");
                xi = EntradaTeclado.leDouble();

            } catch (Exception e) {

                System.out.println("Valor invalido, tente novamente.");
                continue;
            }
            break;            
        }
        
        do {
            xi1 = xi;
            xi = ( (x/xi1) + (xi1) ) / 2;
            diff = (xi - xi1);
            
        } while(diff >= 0.00000001);

        System.out.println("Valor: " + xi + " Margem de erro: " + diff);
    }
}