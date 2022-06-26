public class AVLTree {

    public Node root;
    private boolean edit=false;
    public AVLTree()
    {
        //default constructor
        root = null;
    }

    public Node insertItem(int date, float temp, boolean edit)
    {
        root = insertItem(date, temp, root, edit);
        return root;
    }

    public Node insertItem(int date, float temperature, Node n, boolean edit)
    {
        if (n == null)
            n = new Node(date, temperature);

        else if (date < n.date)
        {
            //add a node when the given date is earlier than the date on the n.date (n=node)
            n.left = insertItem(date, temperature, n.left, edit);
            n = Rotations.checkRotateLeft(date, n, avlIsBalanced(n));

        }
        else if(date > n.date)
        {
            //add a node when the given date is later than the date on the n.date (n=node)
            n.right = insertItem(date, temperature, n.right, edit);
            n = Rotations.checkRotateRight(date, n, avlIsBalanced(n));

        }else if(edit)
            n.temperature = temperature;

        n.height=getMaxHeight(getHeight(n.left), getHeight(n.right)) + 1;
        return n;
    }

    public static int getHeight(Node n){
        if(n==null)
            return -1;
        else
            return n.height;
    }

    public static int getMaxHeight(int leftHeight, int rightHeight){
        if(leftHeight>rightHeight)
            return leftHeight;
        else
            return rightHeight;
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
            System.out.println(getHeight(head) + " " + position +" " + dateString + " " + head.temperature);
            printInOrderAVL(head.right, "right");
        }
    }


    //checking if the node is not balanced
    //0 -> node balanced
    //else -> node unbalanced

    public int avlIsBalanced(Node node){
        if(node == null)
            return 0;
        else
            return AVLTree.getHeight(node.right) - AVLTree.getHeight(node.left);
    }

   public Node minDate(Node node)
    {
        Node min = node;

        if(node == null)
            return null;

        while (min.left != null)
            min = min.left;

        return min;
    }
}