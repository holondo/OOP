public class Contact {
    private String ID, name, email, address;

    public Contact(String ID, String name, String email, String address)
    {
        setID(ID);
        setName(name);
        setEmail(email);
        setAddress(address);
    }

    public void setID(String IDNumber)
    {
        this.ID = IDNumber;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getAddress()
    {
        return this.address;
    }

    @Override
    public String toString()
    {
        String strShow = "";
        strShow += "Nome: " + this.name;
        strShow += "\nEmail: " + this.email;
        strShow += "\nEndereço: " + this.address;
        return strShow;
    }
}
