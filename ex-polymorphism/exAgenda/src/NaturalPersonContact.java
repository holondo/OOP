public class NaturalPersonContact extends Contact {
    private String birthDate, maritalStatus;

    public NaturalPersonContact(String name, String email, String address, String ID, String birthDate, String maritalStatus)
    throws IllegalArgumentException
    {
        super(ID, name, email, address);

        formatToCPF(ID);
        setBirthDate(birthDate);
        setMaritalStatus(maritalStatus);
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

    public String getBirthDate()
    {
        return birthDate;
    }

    public String getMaritalStatus()
    {
        return maritalStatus;
    }

    private String formatToCPF(String ID)
    throws IllegalArgumentException 
    {
        if(ID.length() != 11) throw new IllegalArgumentException("CPF deve ter 11 dígitos.");
        String strFormatted = "";
        strFormatted += ID.substring(0, 3) + '.' + ID.substring(3, 6) + '.' + ID.substring(6, 9) + '-' + ID.substring(9, 11);
        return strFormatted;
    }

    @Override
    public String toString()
    {
        String strShow = "";
        strShow += "\n**Tipo de contato: Pessoa Física.";
        strShow += "\nNome: " + this.getName();
        strShow += "\nCPF: " + formatToCPF(this.getID());
        strShow += "\nNascimento: " + this.getBirthDate();
        strShow += "\nEmail: " + this.getEmail();
        strShow += "\nEndereço: " + this.getAddress() + "\n";
        return strShow;
    }
}
