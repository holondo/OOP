import java.util.ArrayList;

public class Teste{
    public static void main(String[] args) {
        ArrayList<GeometricFigure> figures = new ArrayList<GeometricFigure>();
        String cor = "";
        boolean preenchido;
        GeometricFigure aux;
        int opt = 0;
        while(opt != 9)
        {
            try
            {
                System.out.println("Deseja criar um (1)Circulo ou (2)Retângulo?\nPara sair digite 9.\nPara exibir as formas criadas digite 3.");
                opt = EntradaTeclado.leInt();

                switch (opt) {
                    case 1:
                        System.out.println("Insira o raio do circulo.");
                        double raio = EntradaTeclado.leDouble();

                        System.out.println("Digite a cor do circulo.");
                        cor = EntradaTeclado.leString();

                        System.out.println("Deseja que o cículo seja preenchido? (0)Não | (1)Sim");
                        preenchido = (EntradaTeclado.leInt() == 0) ? false : true; 

                        aux = new Circle(raio, cor, preenchido);
                        figures.add(aux);
                        System.out.println(aux.toString());
                    break;
                    
                    case 2:
                        System.out.println("Insira a base do retângulo.");
                        double base = EntradaTeclado.leDouble();

                        System.out.println("Insira a altura do retângulo.");
                        double altura = EntradaTeclado.leDouble();
                        
                        System.out.println("Digite a cor do retângulo.");
                        cor = EntradaTeclado.leString();

                        System.out.println("Deseja que o retângulo seja preenchido? (0)Não | (1)Sim");
                        preenchido = (EntradaTeclado.leInt() == 0) ? false : true; 

                        aux = new Rectangle(base, altura, cor, preenchido);
                        figures.add(aux);
                        System.out.println(aux.toString());
                    break;

                    case 3:
                        for(GeometricFigure figure : figures)
                        {
                            System.out.println(figure.toString()); 
                        }
                    default:
                        break;
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }            
        }
    }
}
