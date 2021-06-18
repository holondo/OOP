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

    void insertionSort()
    {
        Contact key;
        int i, j;
        for (i = 1; i < this.contactsAmnt; i++)
        {
            key = this.contactsArr[i];
            j = i - 1;

            while (j >= 0 && Long.parseLong(this.contactsArr[j].getID()) > Long.parseLong(key.getID()))
            {
                this.contactsArr[j + 1] = this.contactsArr[j];
                j = j - 1;
            }
            this.contactsArr[j + 1] = key;
        }
    }

    int binarySearch(Long x, int l, int r)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (Long.parseLong(this.contactsArr[mid].getID()) == x)
                return mid;

            if (Long.parseLong(this.contactsArr[mid].getID()) > x)
                return binarySearch(x, l, mid - 1);

            return binarySearch(x, mid + 1, r);
        }
        return -1;
    }

    public void remove(String ID)
    {
        int place = binarySearch(Long.parseLong(ID), 0, this.contactsAmnt);
        if(place == -1) return;

        System.arraycopy(this.contactsArr, place + 1, this.contactsArr, place, this.contactsArr.length - 1 - place);
        this.contactsAmnt--;
    }

    @Override
    public String toString()
    {
        insertionSort();
        String strShow = "";

        for (Contact contact : contactsArr)
        {
             if(contact == null) break;

             strShow += contact.toString();
        }

        return strShow;
    }
}