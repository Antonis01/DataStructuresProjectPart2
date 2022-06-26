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
            String strDate = addChar.splitDate(n.date);
            return "The maximum temperature is " + Float.toString(n.temperature) + " degrees Celsius and the date is " + strDate;
        }catch (NullPointerException npe){
            return "Date not found";
        }
    }
}
