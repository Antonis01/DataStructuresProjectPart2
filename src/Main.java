import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static ArrayList<oceanEntries> dataOcean = new ArrayList<>(loadCSV.load_CSV_file());

    public static void main(String[] args) throws InterruptedException {

        generalMenu.generalMenu();


    }
}