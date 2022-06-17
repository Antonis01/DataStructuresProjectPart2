public class Date{

    private String month, day, year;

    public Date(String year, String month, String day) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String displayDate(){
        return year + "/" + month + "/" + day;
    }

    public Integer displayIntDate() {return Integer.parseInt(year + month + day); }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }
}