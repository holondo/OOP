import java.io.IOException;
import java.lang.Math;

public class Equation {

    public static void main(String[] args) throws Exception {

        double a, b, c;

        while (true) {

            System.out.println("Digite o valor dos coeficientes a, b e c.");
            try {
                a = EntradaTeclado.leDouble();
                b = EntradaTeclado.leDouble();
                c = EntradaTeclado.leDouble();
                
            } catch (Exception e) {
    
                System.out.println("Valor incompativel. Tente novamente.");  
                continue;          
            }            
            break;           
        }        
        bhaskara(a,b,c);

        return;
    }

    public static void bhaskara(double a, double b, double c) {
        double[] x = {0,0};
        double delta = (b * b) - (4 * a * c);

        System.out.println(a +" "+b+" "+c+" "+ delta);
        if(delta < 0 )
            System.out.println("Não existe solução nos numeros reais.");
        else{
            x[0] = ( (-b) + Math.sqrt(delta) ) / (2 * a);
            x[1] = ( (-b) - Math.sqrt(delta) ) / (2 * a);

            System.out.println("x = " + x[0] + " e x = " + x[1] + " são soluções para a equação.");
        }
        return ;
    }
    
}\