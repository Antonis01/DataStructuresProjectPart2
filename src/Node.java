public class Node {
    public int date;
    public float temperature;
    public int height;
    public Node left;
    public Node right;

    public Node(int date, float temperature){
        this.date = date;
        this.temperature = temperature;
        height = 0;
        left = null;
        right = null;
    }
}