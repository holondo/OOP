public class Agenda {
    public static void main(String[] args) {
        ContactBook cBook = new ContactBook();
        int opt = 0, entityOpt=0;

        while(opt != 9)
        {
            System.out.println("Selecione a opção da agenda:\n(1): Adicionar contato.\n(2): Remover contato.\n(3): Exibir todos os contatos.\n(9): SAIR");
            
            try{opt = EntradaTeclado.leInt();}
            catch(Exception e){continue;}
            
            switch (opt) {
                case 1:
                    System.out.println("Deseja adicionar:\n(1): Pessoa física\n(2): Pessoa jurídica");
                    try{entityOpt = EntradaTeclado.leInt();}
                    catch(Exception e)
                    {
                        System.out.println("Opção não reconhecida");
                        opt = 0;
                        continue;
                    }

                    if(entityOpt == 1 || entityOpt == 2)insereTipo(cBook, entityOpt);
                    break;
                
                case 2:
                    try{
                        String ID = askForInput("Digite o CPF ou CNPJ do contato que deseja eliminar:");
                        cBook.remove(ID);
                    }
                    catch(Exception e){System.out.println(e.getCause());}
                    break;

                case 3:
                    System.out.println(cBook.toString());
                    break;
            
                default:
                    break;
            }
        }

        System.out.println(cBook.toString());
    }

    public static void insereTipo(ContactBook cBook, int tipo)
    {
        boolean readFlag = false;
        while(!readFlag)
        {
            try 
            {
                if(tipo == 1)
                {
                    NaturalPersonContact pessoaFísica = new NaturalPersonContact(askForInput("Insira o nome:"), askForInput("Insira o email:"), askForInput("Insira o endereço:")
                    ,  askForInput("Insira o CPF:"), askForInput("Insira a data de nascimento:"), askForInput("Insira o estado civíl:"));
                    cBook.add(pessoaFísica);
                }
                else if(tipo == 2)
                {
                    LegalEntityContact pessoaJuridica = new LegalEntityContact(askForInput("Insira o nome:"), askForInput("Insira o email:"), askForInput("Insira o endereço:")
                    ,  askForInput("Insira o CNPJ:"), askForInput("Insira a razão social:"), askForInput("Insira a inscrição estadual:"));
                    cBook.add(pessoaJuridica);
                }
                
                readFlag = true;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public static String askForInput(String output) throws Exception
    {
        System.out.println(output);
        return EntradaTeclado.leString();
    }
}
