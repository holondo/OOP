public class Main {

    public static void main(String[] args) {
        
        Loja loja = new Loja();
        Product aux;
        String strAux;
        boolean worked = false;
        int opt = 0, optProd = 0;

        while(opt != 9)
        {
            worked = false;
            System.out.println("Loja\n(1)Adicionar Produto.\n(2)Vender produto\n(3)Buscar produto\n(4)Exibir relatório.\n(9)SAIR.\n");

            try{opt = EntradaTeclado.leInt();}
            catch(Exception e){continue;}

            switch (opt) {

                case 1:
                    while(!worked)
                    {
                        try
                        {
                            System.out.println("Qual tipo de produto deseja adicionar?\n(1)CD\n(2)DVD\n(3)Livro\n");
                            optProd = EntradaTeclado.leInt();
                            
                            aux = completaProduto(optProd);
                            loja.addProduct(aux);
                            worked = true;
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }                    
                    break;

                case 2:
                    try
                    {
                        System.out.println("Digite o nome ou código de barras do produto que deseja vender:\n");
                        strAux = EntradaTeclado.leString();

                        System.out.println("Insira a quantidade do produto:\n");
                        int quant = EntradaTeclado.leInt();
                        
                        loja.sell(strAux, quant);
                        worked = true;
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage() + '\n');
                    }
                    break;

                case 3:
                    try
                    {
                        System.out.println("Digite o nome ou código de barras do produto:\n");
                        strAux = EntradaTeclado.leString();
                        
                        aux = loja.searchProduct(strAux);//Fazer copia?
                        System.out.println(aux.toString());
                        worked = true;
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage() + '\n');
                    }
                    break;

                case 4:
                    System.out.println(loja.toString());
                    break;
            
                default:
                    break;
            }
        }

    }

    public static String askForInput(String output) throws Exception
    {
        System.out.println(output);
        return EntradaTeclado.leString();
    }

    public static Product completaProduto(int opt) throws Exception
    {
        Product aux;
        double preco;
        int emEstoque;
        String nome, codigo, autor, genero, ano;

        System.out.println("\nDigite nome do produto:\n");
        nome = EntradaTeclado.leString();

        System.out.println("\nDigite codigo de barras do produto:\n");
        codigo = EntradaTeclado.leString();

        System.out.println("\nDigite preço do produto:\n");
        preco = EntradaTeclado.leDouble();

        System.out.println("\nQuantas unidades desse produto no estoque?\n");
        emEstoque = EntradaTeclado.leInt();

        if(opt == 1)
        {
            System.out.println("Qual o autor deste CD?\n");
            autor = EntradaTeclado.leString();
            
            System.out.println("Qual o genero musical deste CD?\n");
            genero = EntradaTeclado.leString();

            System.out.println("Em que ano este CD foi lançado?\n");
            ano = EntradaTeclado.leString();

            aux = new CD(nome, preco, codigo, emEstoque, autor, genero, ano);
        }

        else if(opt == 2)
        {
            System.out.println("Qual o autor deste programa?\n");
            autor = EntradaTeclado.leString();
            
            System.out.println("Qual o genero do programa deste DVD?\n");
            genero = EntradaTeclado.leString();

            System.out.println("Em que ano este DVD foi lançado?\n");
            ano = EntradaTeclado.leString();

            aux = new DVD(nome, preco, codigo, emEstoque, autor, genero, ano);
        }

        else
        {
            System.out.println("Qual o autor deste livro?\n");
            autor = EntradaTeclado.leString();
            
            System.out.println("Qual o genero literario deste livro?\n");
            genero = EntradaTeclado.leString();

            System.out.println("Em que ano este livro foi lançado?\n");
            ano = EntradaTeclado.leString();

            aux = new Book(nome, preco, codigo, emEstoque, autor, genero, ano);
        }

        return aux;
    }
    
}
