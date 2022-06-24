import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu_B {

    public Menu_B() {
    }

    public static void menu() throws InterruptedException {
        AVLTreeTemperature tree = new AVLTreeTemperature();

        int input;
        String inputDate;
        for(var i: Main.dataOcean){
            tree.insertItem(i.getDate().displayIntDate(),i.getT_degC());
        }
        Main.dataOcean.removeAll(Main.dataOcean);     //deleting all the data from the dataOcean ArrayList

        do{
            System.out.println("========AVL TREE MENU /// Exercise B========\n1)Print AVL Tree data in order.\n2)Find the date with the minimum temperature.");
            System.out.println("3)Find the date with the maximum temperature.\n4)Exit the program.");
            System.out.print("============================================\nType a number...");

            try {
                Scanner scan = new Scanner(System.in);
                input = scan.nextInt();


                switch (input) {
                    case 1:
                        tree.printInOrderAVL();
                        break;

                    case 2:
                        System.out.println(findMinTemp.findMin(tree.root));
                        break;

                    case 3:
                        System.out.println(findMaxTemp.findMax(tree.root));
                        break;

                    case 4:
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
