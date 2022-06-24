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
            String strDate = addChar.splitDate(Integer.toString(n.date),'/',4);
            return "The minimum temperature is " + Float.toString(n.temperature) + " degrees Celsius " + addChar.splitDate(strDate,'/',7);
        }catch (NullPointerException npe){
            return "Date not found";
        }
    }
}
