public class Rotations {
    public static Node rotateLeft(Node n1)
    {
        Node n2 = n1.left;
        n1.left = n2.right;
        n2.right = n1;
        n1.height = AVLTree.getMaxHeight(AVLTree.getHeight(n1.left), AVLTree.getHeight(n1.right)) + 1;
        n2.height = AVLTree.getMaxHeight(AVLTree.getHeight(n2.left), n1.height) + 1;
        return n2;
    }

    public static Node rotateRight(Node n1)
    {
        Node n2 = n1.right;
        n1.right = n2.left;
        n2.left = n1;
        n1.height = AVLTree.getMaxHeight(AVLTree.getHeight(n1.left), AVLTree.getHeight(n1.right)) + 1;
        n2.height = AVLTree.getMaxHeight(AVLTree.getHeight(n2.right), n1.height) + 1;
        return n2;
    }

    public static Node doubleRotateLeft(Node n)
    {
        n.left = rotateRight(n.left);
        return rotateLeft(n);
    }

    public static Node doubleRotateRight(Node n)
    {
        n.right = rotateLeft( n.right );
        return rotateRight( n );
    }

    public static Node checkRotateRight(int date, Node n, int height){
        if(date > n.date && height ==2){
            if (date > n.right.date)
                n=Rotations.rotateRight(n);
            else
                n=Rotations.doubleRotateRight(n);
        }

        return n;
    }

    public static Node checkRotateLeft(int date, Node n, int height){
        if(date < n.date && height == -2){
            if (date < n.left.date)
                n=Rotations.rotateLeft(n);
            else
                n=Rotations.doubleRotateLeft(n);
        }

        return n;
    }
}