public class ContactBook {
    private static final int SIZE = 100;
    private Contact[] contactsArr = new Contact[SIZE];
    private int contactsAmnt = 0;

    public void add(Contact toAdd) throws Exception
    {
        if(this.contactsAmnt + 1 > SIZE)
            throw new Exception("Lista de contatos cheia.");
        
        contactsArr[contactsAmnt++] = toAdd;
    }

    @Override
    public String toString()
    {
        String strShow = "";

        for (Contact contact : contactsArr)
        {
             if(contact == null) break;

             strShow += contact.toString();
        }

        return strShow;
    }
}
