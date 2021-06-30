package Utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class UtilityManager {

    public String getStringInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int getIntInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public String generateID(){
        return Integer.toString( 1000 + new Random().nextInt(9000));
    }

    public String getCurrentTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String strTime = dateFormat.format(date);
        return strTime;
    }

    public Date getDatefromString(String date) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
        return date1;
    }
}
