package finalProject;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String currentPath = new File("").getAbsolutePath();
    static String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
    static File smoothiesHistory = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\" + currentDateTime + ".xml");
    public static void main(String[] args) {
        System.out.println("Hey, do you want to make a smoothie?");
        List<Smoothie> madeSmoothie = new ArrayList<>();
        boolean makingSmoothie = InputScanner.isAnswerYes();
        while (makingSmoothie) {
            Smoothie yourSmoothie = Smoothie.input();
            yourSmoothie.payForSmoothie();
            madeSmoothie.add(yourSmoothie);
            System.out.println("Please, wait a little while your smoothie is being made");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("It is almost done!");
            }
            System.out.println("Here is your " + yourSmoothie + "! Enjoy!");
            System.out.println("Do you want make one more smoothie?");
            makingSmoothie = InputScanner.isAnswerYes();
        }
        Smoothie.saveToFile(smoothiesHistory, madeSmoothie);
        System.out.println("See you next time! Bye!");
    }
}
