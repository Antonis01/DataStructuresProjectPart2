public class oceanEntries{
    private float T_degC;
    private Date date;

    public oceanEntries(Date date,float t_degC) {
        this.date = date;
        this.T_degC = t_degC;
    }

    public float getT_degC() {
        return T_degC;
    }

    public Date getDate() {
        return date;
    }
}