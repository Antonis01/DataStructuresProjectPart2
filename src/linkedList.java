public class linkedList {

    llNode head;

    public void add(oceanEntries data)
    {
        //LL is empty
        if(this.head == null)
        {
            this.head = new llNode(data);
        }
        //LL is NOT empty
        else
        {
            llNode llnodeToAdd = new llNode(data);
            llnodeToAdd.next = this.head;
            this.head = llnodeToAdd;
        }
    }
}
