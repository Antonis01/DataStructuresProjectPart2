import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<oceanEntries> dataOcean = new ArrayList<>(loadCSV.load_CSV_file());

    public static void main(String[] args) {

        int j=0;
        for(var i: dataOcean){
            System.out.println(++j + " " + i.getDate().displayDate() + " " + i.getT_degC());
        }

    }
}