import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu_C {

    public Menu_C(){
    }

    public static void menu() throws InterruptedException {

        //Preparing the Hash Table
        hashing hashingTable = new hashing();
        hashingTable.initializeHashingTable();
        for(int i = 0; i<=1404; i++){
            hashingTable.addToHashTable(Main.dataOcean.get(i));
        }
        Main.dataOcean.removeAll(Main.dataOcean);     //deleting all the data from the dataOcean ArrayList

        int input;
        String inputDate, intDate;
        String year,month,day;
        float inputTemperature;

        do{
            System.out.println("========HASHING /// Exercise C========\n1)Search for a temperature based on a date.\n2)Change a temperature of a specified date");
            System.out.println("3)Delete an entry of a specified date.\n4)Display Hashing Table.\n5)Exit the program.");
            System.out.print("============================================\nType a number...");

            try {
                Scanner scan = new Scanner(System.in);
                input = scan.nextInt();


                switch (input) {
                    case 1:
                        System.out.println("Give a date to get it's temperature.\nThe day must be of the following form: \nyyyy/mm/dd");
                        inputDate = scan.next();
                        intDate = inputDate.replaceAll("/", ""); //it splits the date

                        //Converting The Date into a Date Variable
                        year = Character.toString(intDate.charAt(0)) + Character.toString(intDate.charAt(1)) + Character.toString(intDate.charAt(2)) + Character.toString(intDate.charAt(3));
                        month = Character.toString(intDate.charAt(4)) + Character.toString(intDate.charAt(5));
                        day = Character.toString(intDate.charAt(6)) + Character.toString(intDate.charAt(7));
                        Date case1_Date = new Date(year,month,day);

                        hashingTable.searchTemp(case1_Date);
                        break;

                    case 2:
                        System.out.println("Give a date that you want to edit.\nThe day must be of the following form: \nyyyy/mm/dd");
                        inputDate = scan.next();
                        System.out.print("Enter New Temperature: ");
                        inputTemperature = scan.nextFloat();
                        intDate = inputDate.replaceAll("/", ""); //it splits the date

                        //Converting The Date into a Date Variable
                        year = Character.toString(intDate.charAt(0)) + Character.toString(intDate.charAt(1)) + Character.toString(intDate.charAt(2)) + Character.toString(intDate.charAt(3));
                        month = Character.toString(intDate.charAt(4)) + Character.toString(intDate.charAt(5));
                        day = Character.toString(intDate.charAt(6)) + Character.toString(intDate.charAt(7));
                        Date case2_Date= new Date(year,month,day);

                        hashingTable.modifyTemp(case2_Date, inputTemperature);
                        System.out.println("Temperature Modified to "+ inputTemperature + "!");
                        break;

                    case 3:
                        System.out.println("Give a date that you wish to delete.\nThe day must be of the following form: \nyyyy/mm/dd");
                        inputDate = scan.next();
                        intDate = inputDate.replaceAll("/", ""); //it splits the date

                        //Converting The Date into a Date Variable
                        year = Character.toString(intDate.charAt(0)) + Character.toString(intDate.charAt(1)) + Character.toString(intDate.charAt(2)) + Character.toString(intDate.charAt(3));
                        month = Character.toString(intDate.charAt(4)) + Character.toString(intDate.charAt(5));
                        day = Character.toString(intDate.charAt(6)) + Character.toString(intDate.charAt(7));
                        Date case3_Date = new Date(year,month,day);

                        hashingTable.deleteEntry(case3_Date);
                        break;

                    case 4:
                        int num=1;
                        for(int i = 0; i<=8; i++){
                            System.out.print(" ["+num+"]");
                            hashingTable.printRow(i);
                            num++;
                        }
                        for(int i = 9; i<=10; i++){
                            System.out.print("["+num+"]");
                            hashingTable.printRow(i);
                            num++;
                        }

                        break;


                    case 5:
                        System.out.println("Exiting the program\n...");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("...");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("...");
                        TimeUnit.SECONDS.sleep(1);
                        System.exit(0);
                        break;


                    default:
                        System.out.println("Wrong Input");

                }
            }catch (InputMismatchException ime){
                System.out.println("Wrong Input!!!");
            }

            System.out.println("============================================");
        }while (true);

    }
}
