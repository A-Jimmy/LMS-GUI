import org.example.LMS;
import org.example.LMSController;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;


public class LMSTest {

    @Test
    public void bookAddedToDatabase(){
        LMS book;
        ArrayList database = new ArrayList<>();
        book = new LMS(100,"title", "author", "", "");
        database.add(book);
        Assert.assertEquals(1, database.size());
    }


    @Test
    public void removeBookWithBarcode(){
        LMS book;
        ArrayList<LMS> database = new ArrayList<LMS>();
        book = new LMS(100,"title", "author", "", "");
        database.add(book);

        Assert.assertEquals(1, database.size());
        int barcode = 100;
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getBarcode() == barcode) {
                database.remove(i);
            }
          Assert.assertEquals(0, database.size());

    }
    }

    @Test
    public void removeBookWithTitle(){
        LMS book;
        ArrayList<LMS> database = new ArrayList<LMS>();
        book = new LMS(100,"title", "author", "", "");
        database.add(book);
        Assert.assertEquals(1, database.size());
      String title = "title";
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getTitle().equals(title)) {
                database.remove(i);
            }
            Assert.assertEquals(0, database.size());

        }
    }

    @Test
    public void checkOut(){
        LocalDate date = LocalDate.now();
        LocalDate due = date.plusDays(30);
        String day = String.valueOf(date);
        LMS book;
        ArrayList<LMS> database = new ArrayList<LMS>();
        book = new LMS(100,"title", "author", "",day);
        database.add(book);
        Assert.assertEquals(1, database.size());
        String title = "title";
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getTitle().equals(title) && !database.get(i).getStatus().equals("Checked Out")) {
                      database.get(i).setDueDate(String.valueOf(due));
                         break;
            }else if(database.get(i).getTitle().equals(database) && database.get(i).getStatus().equals("Checked Out")){

Assert.assertEquals("Checked In", database.get(i).getStatus());
Assert.assertEquals(due,database.get(i).getDueDate());

            }

        }
    }
    @Test
    public void checkIn(){

        LMS book;
        ArrayList<LMS> database = new ArrayList<LMS>();
        book = new LMS(100,"title", "author", "", "");
        database.add(book);
        Assert.assertEquals(1, database.size());
        String title = "title";
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getTitle().equals(title) && database.get(i).getStatus().equals("")) {
                database.get(i).setStatus("Checked In");
                database.get(i).setDueDate("null");
                break;
            }
            Assert.assertEquals("Checked In", database.get(i).getStatus());
            Assert.assertEquals("null",database.get(i).getDueDate());

        }

    }
    }

