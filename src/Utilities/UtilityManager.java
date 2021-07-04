package Utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public boolean isValidPassword(String password)
    {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
