public class Contact {
    private String name, email, address;

    public Contact(String name, String email, String address)
    {
        setName(name);
        setEmail(email);
        setAddress(address);
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
