import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu_A {

    public Menu_A() {
    }

    public static void menu() throws InterruptedException {
        AVLTree tree = new AVLTree();
        searchAVL search = new searchAVL();
        String inputDate;
        for(var i: Main.dataOcean){
            tree.insertItem(i.getDate().displayIntDate(),i.getT_degC());
        }
        Main.dataOcean.removeAll(Main.dataOcean);     //deleting all the data from the dataOcean ArrayList


        System.out.println("===AVL TREE MENU /// Exercise A===\n1)Print AVL Tree data in order.\n2)Search for a temperature based on a date.");
        System.out.println("3)Change a temperature of a specified date.\n4)Delete an entry of a specified date.\n5)Exit the program.");
        int input;
        Scanner scan = new Scanner(System.in);
        input=scan.nextInt();

        switch (input){
            case 1:
                tree.printInOrderAVL();
                break;

            case 2:
                System.out.println("Give a date to get it's temperature.\nThe day must be of the following form: yyyy/mm/dd");
                inputDate = scan.next();
                String intDate = inputDate.replaceAll("/",""); //it splits the date
                System.out.println(search.searchAVL(Integer.parseInt(intDate), tree.root));
                break;

            case 3:
                editTemperature editT = new editTemperature();
                System.out.println("Give a date to get it's temperature.\nThe day must be of the following form: yyyy/mm/dd");
                inputDate = scan.next();
                intDate = inputDate.replaceAll("/",""); //it splits the date
                System.out.println(editT.editTemp(Integer.parseInt(intDate), tree.root, tree));
                break;

            case 4:
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

    }
}
