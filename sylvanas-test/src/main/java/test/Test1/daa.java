package test.Test1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class daa {
    public static void main(String[] args) {
        HashMap<String, Object> queryTime = new HashMap<>();
        queryTime.put("signTimeStart", new Date());
        queryTime.put("signTimeEnd", new Date());
        Date signTimeStart = (Date) queryTime.get("signTimeStart");
        Date signTimeEnd = (Date) queryTime.get("signTimeEnd");

        queryTime.put("signTimeStart", subtractTime(signTimeStart, 600_000));
        queryTime.put("signTimeEnd", subtractTime(signTimeEnd, 600_000));

        System.out.println(queryTime);

    }

    private static Date subtractTime(Date date, int amount) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strTime = sdf.format(date.getTime() - amount);
            Date time = sdf.parse(strTime);
            return time;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
