public class AVLTreeTemperature {

    public Node root;
    private boolean edit=false;
    public AVLTreeTemperature()
    {
        //default constructor
        root = null;
    }

    public Node insertItem(int date, float temp)
    {
        root = insertItem(date, temp, root);
        return root;
    }

    public Node insertItem(int date, float temperature, Node n)
    {
        if (n == null)
            n = new Node(date, temperature);

        else if (temperature < n.temperature)
        {
            //add a node when the given date is earlier than the date on the n.date (n=node)
            n.left = insertItem(date, temperature, n.left);
            n = Rotations.checkRotateLeftTemp(temperature, n, AVLTree.getHeight(n.right) - AVLTree.getHeight(n.left));

        }
        else if(temperature > n.temperature) {
            //add a node when the given date is later than the date on the n.date (n=node)
            n.right = insertItem(date, temperature, n.right);
            n = Rotations.checkRotateRightTemp(temperature, n, AVLTree.getHeight(n.right) - AVLTree.getHeight(n.left));
        }

        n.height=AVLTree.getMaxHeight(AVLTree.getHeight(n.left), AVLTree.getHeight(n.right)) + 1;
        return n;
    }

    public void printInOrderAVL(){
        printInOrderAVL(root,"root");
    }

    public void printInOrderAVL(Node head, String position)
    {
        String dateString = "";


        if (head != null)
        {
            dateString = addChar.splitDate(head.date);

            printInOrderAVL(head.left, "left");
            System.out.println(AVLTree.getHeight(head)+1 + " " + position +" " + dateString + " " + head.temperature);
            printInOrderAVL(head.right, "right");
        }
    }
}