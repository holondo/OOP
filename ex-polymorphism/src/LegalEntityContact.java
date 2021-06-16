public class LegalEntityContact extends Contact{
    private String legalEntityID, corporateName, stateRegistration;

    public LegalEntityContact(String name, String email, String address, String legalEntityID, String corporateName, String stateRegistration)
    {
        super(name, email, address);
        setLegalEntityID(legalEntityID);
        setCorporateName(corporateName);
        setStateRegistration(stateRegistration);
    }

    public void setCorporateName(String corporateName)
    {
        this.corporateName = corporateName;
    }

    public void setLegalEntityID(String legalEntityID)
    {
        this.legalEntityID = legalEntityID;
    }
    public void setStateRegistration(String stateRegistration)
    {
        this.stateRegistration = stateRegistration;
    }

    //Getters area
    public String getCorporateName() 
    {
        return corporateName;
    }
    public String getLegalEntityID() 
    {
        return legalEntityID;
    }
    public String getStateRegistration()
    {
        return stateRegistration;
    }

    private String formatToCNPJ(String ID) throws IllegalArgumentException
    {
        if(ID.length() != 14) throw new IllegalArgumentException("CNPJ deve ter 14 dígitos.");
        String strFormatted = "";
        strFormatted += ID.substring(0, 1) + '.' + ID.substring(2, 4) + '.' + ID.substring(5, 7) + '/' 
        +ID.substring(8, 11) + '-' + ID.substring(12);
        return strFormatted;
    }

    @Override
    public String toString()
    {
        String strShow = "";
        strShow += "Tipo de contato: Pessoa Jurídica.";
        strShow += "\nNome: " + this.getName();
        strShow += "\nCNPJ: " + formatToCNPJ(this.getLegalEntityID());
        strShow += "\nRazão Social: " + this.getCorporateName();
        strShow += "\nInscrição Estadual: " + this.getStateRegistration();
        strShow += "\nEmail: " + this.getEmail();
        strShow += "\nEndereço: " + this.getAddress();
        return strShow;
    }
}
