public class deleteNode extends searchAVL {

    public Node deleteNode(int date, Node n) {
        AVLTree avlTree = new AVLTree();

        if (n == null)
            return n;

        int checkDate = n.date;
        Node temp = null;

        if (date < n.date)
            n.left = deleteNode(date, n.left);
        else if (date > n.date)
            n.right = deleteNode(date, n.right);
        else {
            if (n.right == null || n.left == null) {
                temp = null;
                if (n.right == temp)
                    temp = n.left;
                else if (n.left == null)
                    temp = n.right;

                if (temp == null){
                    temp = n;
                    n= null;
                }
                else
                    n = temp;

            } else {

                temp = avlTree.minDate(n.right);
                n.date = temp.date;
                n.temperature = temp.temperature;
                n.right = deleteNode(temp.date, n.right);
            }
        }

        if (n == null)
            return n;

        n.height = AVLTree.getMaxHeight(AVLTree.getHeight(n.left), AVLTree.getHeight(n.right)) + 1;

        int tempHeight = avlTree.avlIsBalanced(n);

        n = Rotations.checkRotateLeft(date, n, tempHeight);
        n = Rotations.checkRotateRight(date, n, tempHeight);

        return n;
    }
}