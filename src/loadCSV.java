import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class loadCSV {

    public static ArrayList<oceanEntries> load_CSV_file() {
        String splitBy = ",", splitBy2 = "/";
        ArrayList<oceanEntries> oceanArray = new ArrayList<>();
        String[] tempString = new String[2];
        String[] tempDateString = new String[3];

        try {

            BufferedReader readCSV = new BufferedReader(new FileReader("ocean.csv"));

            String readLine = readCSV.readLine();

            while((readLine = readCSV.readLine())!=null){
                tempString = readLine.split(splitBy);   //it splits the data of the line 
                tempDateString = tempString[0].split(splitBy2); //it splits the date

                var date = new Date(tempDateString[2],tempDateString[0], tempDateString[1]);
                var oceanEn = new oceanEntries(date, Float.parseFloat(tempString[1]));

                oceanArray.add(oceanEn);
            }


        }catch (IOException e){
            e.printStackTrace();
        }
        return oceanArray;
    }
}