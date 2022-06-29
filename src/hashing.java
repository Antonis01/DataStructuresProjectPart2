public class hashing {


    linkedList hashingTable[] = new linkedList[11];

    public void initializeHashingTable(){

        for(int i = 0; i<=10; i++){
            hashingTable[i] = new linkedList();
        }
    }

    public int calculateIndex(Date date){

        //CONVERTING THE DATE TO CHARACTERS
        String stringDate= date.getYear() + date.getMonth() + date.getDay();
        char[] dateCharacters = new char[10];
        dateCharacters[4]='/';
        dateCharacters[7]='/';

        for(int i = 0; i<=7; i++){
            if(i>=0&&i<=3){dateCharacters[i]=stringDate.charAt(i);}
            else if(i>=4&&i<=5){dateCharacters[i+1]=stringDate.charAt(i);}
            else if(i>=6&&i<=7){dateCharacters[i+2]=stringDate.charAt(i);}
        }

        //ADDING THE CHARACTERS ASCII VALUES
        int hashCode=0;
        for(int i = 0; i<=9; i++){
            hashCode = hashCode + (int)dateCharacters[i];
        }

        //GENERATING INDEX
        int index = hashCode%11;

        return index;
    }

    public void addToHashTable(oceanEntries entry){
        //ADDING OCEAN ENTRY TO HASH TABLE
        hashingTable[calculateIndex(entry.getDate())].add(entry);
    }

    public void searchTemp(Date date){

        linkedList hashingTableRow;
        int index = calculateIndex(date);
        hashingTableRow = hashingTable[index];

        llNode pointer = hashingTableRow.head;
        while (pointer!=null){
            if(pointer.data.getDate().displayDate().equals(date.displayDate())){
                System.out.println("Temperature at "+date.displayDate()+ " is: "+pointer.data.getT_degC()+" Celsius");
                return;
            }
            pointer = pointer.next;
        }
        System.out.println("Date Not Found");
    }

    public void modifyTemp (Date date, float newtTemp){

        int index = calculateIndex(date);
        llNode pointer = hashingTable[index].head;

        //Checking the Head First
        if(pointer.data.getDate().displayDate().equals(date.displayDate())){
            hashingTable[index].head.data.setT_degC(newtTemp);
            return;
        }

        //Checking the rest
        while(pointer.next!=null){
            if(pointer.next.data.getDate().displayDate().equals(date.displayDate())){
                pointer.next.data.setT_degC(newtTemp);
                return;
            }
            pointer = pointer.next;
        }

        System.out.println("Date Not Found");
    }

    public void deleteEntry(Date date){

        int index = calculateIndex(date);
        llNode pointer = hashingTable[index].head;

        //Checking the Head First
        if(pointer.data.getDate().displayDate().equals(date.displayDate())){
            hashingTable[index].head = hashingTable[index].head.next;
            return;
        }

        //Checking the Second Element
        if(pointer.next.data.getDate().displayDate().equals(date.displayDate())){
            hashingTable[index].head.next = hashingTable[index].head.next.next;
            return;
        }

        //Cheking The Rest
        //We are starting from the second element because the pointer node checks 2 nodes ahead to be able to delete.
        while(pointer.next!=null){
            if(pointer.next.next.data.getDate().displayDate().equals(date.displayDate())){
                pointer.next.next=pointer.next.next.next;
                return;
            }
            pointer = pointer.next;
        }

        //The Node is At the End
        while (pointer.next.next!=null){
            pointer = pointer.next;
        }

        if(pointer.next.next==null){
            pointer.next = null;
            return;
        }

        //Date Was Not Found
        System.out.println("Date Not Found");

    }

    public void printRow(int index){
        llNode pointer = hashingTable[index].head;
        int num = 1;

        while(pointer.next!=null){
            System.out.print("("+num+") "+pointer.data.getT_degC()+" "+pointer.data.getDate().displayDate()+" || ");
            pointer = pointer.next;
            num++;
        }
        System.out.println(num+") "+pointer.data.getT_degC()+" "+pointer.data.getDate().displayDate());
    }

}
