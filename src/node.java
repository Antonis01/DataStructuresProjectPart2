public class node {
    int date;
    float temperature;
    int height;
    node left;
    node right;

    public node(){
    //constructor for a null node
        date = 0;
        temperature = 0.0f;
        height = 0;
        left = null;
        right = null;
    }

    public node(int date, float temperature){
        //constructor for a null node
        this.date = date;
        this.temperature = temperature;
        height = 0;
        left = null;
        right = null;
    }


}
