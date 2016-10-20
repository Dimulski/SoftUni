package Problem10DateModifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateModifier {
    String firstDate;
    String secondDate;

    DateModifier(String firstDate, String secondDate) {
        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstDate = reader.readLine();
        String secondDate = reader.readLine();

        DateModifier dateModifier = new DateModifier(firstDate, secondDate);
        System.out.println(dateModifier.calcDifferenceInDays());
    }

    public long calcDifferenceInDays() throws ParseException {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
//        Date firstDate = dateFormat.parse(this.firstDate);
//        Date secondDate = dateFormat.parse(this.secondDate);

        String[] firstDateParams = this.firstDate.split("\\s+");
        String[] secondDateParams = this.secondDate.split("\\s+");

        Calendar firstCal = Calendar.getInstance();
        int firstYear = Integer.parseInt(firstDateParams[0]);
        int firstMonth = Integer.parseInt(firstDateParams[1]);
        int firstDay = Integer.parseInt(firstDateParams[2]);
        firstCal.set(firstYear, firstMonth, firstDay);

        Calendar secondCal = Calendar.getInstance();
        int secondYear = Integer.parseInt(secondDateParams[0]);
        int secondMonth = Integer.parseInt(secondDateParams[1]);
        int secondDay = Integer.parseInt(secondDateParams[2]);
        secondCal.set(secondYear, secondMonth, secondDay);

        Date firstDate = firstCal.getTime();
        Date secondDate = secondCal.getTime();

        long firstDateTime = firstDate.getTime();
        long secondDateTime = secondDate.getTime();
        long differenceInTime = secondDateTime - firstDateTime;
        long differenceInDays = differenceInTime / (1000 * 60 * 60 * 24);
        return Math.abs(differenceInDays);
    }
}
