public class addChar {

    public static String splitDate(int date)
    {
        //A method that splits the date back to its original form
        String dateStr = Integer.toString(date);
        StringBuffer s1 = new StringBuffer(dateStr);
        s1.insert(4,'/');
        StringBuffer s2 = new StringBuffer(s1);
        s2.insert(7, '/');
        return s2.toString();
    }
}
