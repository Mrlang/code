package DoDoDo.byteDance;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class mayi_102 {
    Map<Integer, String> orderMap = new HashMap<>();
    LinkedList<Date> tradeEndInfoList = new LinkedList<>();

    SimpleDateFormat format  =  new SimpleDateFormat("yyyyMMdd HH:mm");


    public void init (List tradeDayList) throws ParseException {
        int curIndex = 1;

        for (Object curObj : tradeDayList) {
            String curTradeDay = (String) curObj;
            orderMap.put(curIndex, curTradeDay);
            Date endDate = format.parse(curTradeDay + " 15:00");
            tradeEndInfoList.add(endDate);
            curIndex++;
        }

    }

    public String getTradeDay(Date time,int offsetDays){
        Long timeLong = time.getTime();
        Integer order = 1;

        for (Date dateEndInfo : tradeEndInfoList) {
            if(timeLong < dateEndInfo.getTime()) {
                break;
            }
            order++;
        }

        return orderMap.get(order + offsetDays);
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("20160701");
        list.add("20160704");
        list.add("20160705");

        try {
            init(list);
            Date testDate = format.parse("20160702 09:00");
            String res = getTradeDay(testDate, 0);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
