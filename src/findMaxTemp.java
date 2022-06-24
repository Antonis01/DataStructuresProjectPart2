public class findMaxTemp {

    public static String findMax()
    {
        AVLTreeTemperature avl = new AVLTreeTemperature();
        return findMax(avl.root);

    }

    public static String findMax(Node n){

        try {
            while (n.right != null){
                n = n.right;
            }
            String strDate = addChar.splitDate(Integer.toString(n.date),'/',4);
            return "The maximum temperature is " + Float.toString(n.temperature) + " degrees Celsius and the date is " + addChar.splitDate(strDate,'/',7);
        }catch (NullPointerException npe){
            return "Date not found";
        }
    }
}
