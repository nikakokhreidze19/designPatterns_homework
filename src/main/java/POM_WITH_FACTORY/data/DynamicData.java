package POM_WITH_FACTORY.data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DynamicData {
    public Map<String, String> map = new HashMap<>();
    public DynamicData(){
        map.put("Jan", "იანვარი");
        map.put("Feb", "თებერვალი");
        map.put("Mar", "მარტი");
        map.put("Apr", "აპრილი");
        map.put("May", "მაისი");
        map.put("Jun", "ივნისი");
        map.put("Jul", "ივლისი");
        map.put("Aug", "აგვისტო");
        map.put("Sep", "სექტემბერი");
        map.put("Oct", "ოქტომბერი");
        map.put("Nov", "ნოემბერი");
        map.put("Dec", "დეკემბერი");
    }
    public Date date=new Date();
    public String dateToString=date.toString();
    public String currentMonth=dateToString.split(" ")[1];



    public static String lastOptionHoursDate,movieName,cinemaName;


}
