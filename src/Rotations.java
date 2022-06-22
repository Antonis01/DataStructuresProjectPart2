public class Rotations {
    public static node rotateLeft(node n1)
    {
        node n2 = n1.left;
        n1.left = n2.right;
        n2.right = n1;
        n1.height = AVLTree.getMaxHeight(AVLTree.getHeight(n1.left), AVLTree.getHeight(n1.right)) + 1;
        n2.height = AVLTree.getMaxHeight(AVLTree.getHeight(n2.left), n1.height) + 1;
        return n2;
    }

    public static node rotateRight(node n1)
    {
        node n2 = n1.right;
        n1.right = n2.left;
        n2.left = n1;
        n1.height = AVLTree.getMaxHeight(AVLTree.getHeight(n1.left), AVLTree.getHeight(n1.right)) + 1;
        n2.height = AVLTree.getMaxHeight(AVLTree.getHeight(n2.right), n1.height) + 1;
        return n2;
    }

    public static node doubleRotateLeft(node n)
    {
        n.left = rotateRight(n.left);
        return rotateLeft(n);
    }

    public static node doubleRotateRight(node n)
    {
        n.right = rotateLeft( n.right );
        return rotateRight( n );
    }

}
