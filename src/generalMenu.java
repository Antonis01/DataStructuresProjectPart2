import java.io.IOException;
import java.util.Scanner;

public class generalMenu{

    public static void generalMenu() throws InterruptedException {
        System.out.print("=================PART2 MENU=================\n1)Exercise A\n2)Exercise B.\n3)Exercise C.\nType a number... ");
        int input;
        Scanner scan = new Scanner(System.in);
        input=scan.nextInt();
        System.out.println("============================================");
        switch (input){
                case 1:
                        Menu_A.menu();
                        break;
                case 2:
                        Menu_B.menu();
                        break;
                case 3:
                        break;
                default:
                        System.out.println("Wrong Input");
                        System.exit(0);
        }
    }
}
