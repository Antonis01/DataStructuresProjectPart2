public class addChar {

    public static String splitDate(String date, char symbol, int position)
    {
        //A method that splits the date back to its original form
        StringBuffer sb = new StringBuffer(date);
        sb.insert(position, symbol);
        return sb.toString();
    }
}
