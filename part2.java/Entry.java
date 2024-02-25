import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Entry {
    private int id;
    private String title;

    private String body;

    private LocalDate dateCreated;

    private LocalTime timeCreated;


    public Entry(int id, String title , String body){
            this.id = id ;
            this.title = title;
            this.body = body;
            this.dateCreated = LocalDate.now();
            this.timeCreated = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public  void  setBody(String body){
        this.body = body;
    }
    public String getBody() {
        return body;
    }

    public LocalTime getTimeCreated(){
        return timeCreated;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }



    public String toString(){
        return id +"  "+  body +"  "+ title +"  "+ dateCreated +" "+ timeCreated;
    }


}
class MiniTest{
    public static void main(String[] args) {

        Entry entry = new Entry(1,"am","a");
        Entry entry1 = new Entry(1,"am a ","boy");
        System.out.println(entry);
        System.out.println(entry1);
    }

}