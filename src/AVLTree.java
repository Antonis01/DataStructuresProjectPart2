public class AVLTree {

    public node root;

    public AVLTree()
    {
        //default constructor
        root = null;
    }

    public node insertItem(int date, float temp)
    {
        root = insertItem(date, temp, root);
        return root;
    }

    public node insertItem(int date, float temperature, node n)
    {
        if (n == null) {

            n = new node(date, temperature);

        }
        else if (date < n.date)
        {
            //add a node when the given date is earlier than the date on the n.date (n=node)
            n.left = insertItem(date, temperature, n.left);
            if(getHeight(n.right) - getHeight(n.left) == -2) {
                if (date < n.left.date)
                    n=Rotations.rotateLeft(n);
                else
                    n=Rotations.doubleRotateLeft(n);
            }
        }
        else if(date > n.date)
        {
            //add a node when the given date is later than the date on the n.date (n=node)
            n.right = insertItem(date, temperature, n.right);
            if(getHeight(n.right) - getHeight(n.left) == 2) {
                if (date > n.right.date)
                    n=Rotations.rotateRight(n);
                else
                    n=Rotations.doubleRotateRight(n);
            }
        }else if(date == n.date){
            n.temperature = temperature;
        }

        n.height=getMaxHeight(getHeight(n.left), getHeight(n.right)) + 1;

        return n;
    }

    public static int getHeight(node n){
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

    public void printInOrderAVL(node head, String position)
    {
        String dateString = "";
        char split = '/';
        int height=0;

        if (head != null)
        {
            dateString = addChar.splitDate(Integer.toString(head.date),split,4);
            dateString = addChar.splitDate(dateString,split,7);

            printInOrderAVL(head.left, "left");
            height = getHeight(head) + 1;
            System.out.println(height + " " + position +" " + dateString + " " + head.temperature);
            printInOrderAVL(head.right, "right");
        }
    }
}