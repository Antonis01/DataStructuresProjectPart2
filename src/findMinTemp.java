public class findMinTemp {

    public static String findMin()
    {
        AVLTreeTemperature avl = new AVLTreeTemperature();
        return findMin(avl.root);

    }

    public static String findMin(Node n){

        try {
            while (n.left != null){
                n = n.left;
            }
            String strDate = addChar.splitDate(n.date);
            return "The minimum temperature is " + Float.toString(n.temperature) + "  degrees Celsius and the date is " + strDate;
        }catch (NullPointerException npe){
            return "Date not found";
        }
    }
}
