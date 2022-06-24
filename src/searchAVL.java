public class searchAVL {

    private Node root;

    public String searchAVL(int date)
    {
        AVLTree avl = new AVLTree();
        return searchAVL(date, avl.root);

    }

    public String searchAVL(int date, Node n){
        boolean found = false;
        float temp=0.0f;

        try {
            while(n!=null && !found){

                int checkDate = n.date;

                if(date < checkDate)
                    n=n.left;
                else if(date > checkDate)
                    n=n.right;
                else{
                    found = true;
                    break;
                }

                temp=n.temperature;
            }
            return "The temperature is " + Float.toString(temp) + " degrees Celsius.";
        }catch (NullPointerException npe){
            return "Date not found";
        }
    }
}