public class NaturalPersonContact extends Contact {
    private String naturalPersonID, birthDate, maritalStatus;

    private NaturalPersonContact(String name, String email, String address, String ID, String birthDate, String maritalStatus)
    {
        super(name, email, address);

        setID(ID);
        setBirthDate(birthDate);
        setMaritalStatus(maritalStatus);
    }
    
    public void setID(String IDNumber)
    {
        this.naturalPersonID = IDNumber;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setMaritalStatus(String maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    //Getters area
    public String getID()
    {
        return naturalPersonID;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public String getMaritalStatus()
    {
        return maritalStatus;
    }

    private String formatToCPF(String ID)//ver como so permitir cpf
    throws IllegalArgumentException 
    {
        if(ID.length() != 14) throw new IllegalArgumentException("CNPJ deve ter 14 dígitos.");
        String strFormatted = "";
        strFormatted += ID.substring(0, 2) + '.' + ID.substring(3, 5) + '.' + ID.substring(6, 8) + '-' + ID.substring(9, 10);
        return strFormatted;
    }

    @Override
    public String toString()
    {
        String strShow = "";
        strShow += "Tipo de contato: Pessoa Física.";
        strShow += "\nNome: " + this.getName();
        strShow += "\nCPF: " + formatToCPF(this.getID());
        strShow += "\nNascimento: " + this.getBirthDate();
        strShow += "\nEmail: " + this.getEmail();
        strShow += "\nEndereço: " + this.getAddress();
        return strShow;
    }
}
