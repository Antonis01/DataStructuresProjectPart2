import java.util.Scanner;

public class editTemperature extends searchAVL{

    public String editTemp(int date, Node node, AVLTree tree){
        Scanner scanTemp = new Scanner(System.in);

        float newTemperature;
        try {


                System.out.println("The current temperature is " + searchAVL(date, node) + " degrees Celsius.");
                System.out.println("Type the new temperature that you want to replace the previous one with:");
                newTemperature=scanTemp.nextFloat();

                tree.insertItem(date,newTemperature,node, true);
                String strDate = addChar.splitDate(Integer.toString(date),'/',4);

                return "You have changed the temperature for " + addChar.splitDate(strDate,'/',7) + " to " + Float.toString(newTemperature) + " degrees Celsius.";


        }catch (NumberFormatException nfe){
            return "Date not found";
        }

    }
}