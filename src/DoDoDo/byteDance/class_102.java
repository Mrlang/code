package DoDoDo.byteDance;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class class_102 {
    Map<Integer, String> orderMap = new HashMap<>();
    LinkedList<TradeDayInfo> tradeDayInfoList = new LinkedList<>();

    SimpleDateFormat format  =  new SimpleDateFormat("yyyyMMdd HH:mm");


    public void init (List tradeDayList){
        int curIndex = 1;
        String lastTradeDay = "1970000 00:00";

        for (Object curObj : tradeDayList) {
            String curTradeDay = (String) curObj;
            orderMap.put(curIndex, curTradeDay);

            TradeDayInfo tradeDayInfo = new TradeDayInfo(curTradeDay, lastTradeDay);
            tradeDayInfoList.add(tradeDayInfo);

            lastTradeDay = curTradeDay;
            curIndex++;
        }


    }

    public String getTradeDay(Date time,int offsetDays){
        Long timeLong = time.getTime();
        Integer order = 1;

        for (TradeDayInfo tradeDayInfo : tradeDayInfoList) {
            if(timeLong < tradeDayInfo.endDate.getTime()) {
                break;
            }
            order++;
        }

        return orderMap.get(order + offsetDays);
    }

    @Test
    public void test(){
        List<String> list  = new ArrayList<>();
        list.add("20160701");
        list.add("20160704");
        list.add("20160705");
        init(list);
        try {
            Date testDate = format.parse("20160701 16:00");
            String res = getTradeDay(testDate, 0);
            System.out.println(res);
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

    class TradeDayInfo {
        public Date beginDate;
        public Date endDate;

        TradeDayInfo(String curTradeDay, String lastTradeDay) {
            try {
                //从上个交易日的15:00到该交易日的15:00都属于该交易日
                beginDate = format.parse(lastTradeDay + " 15:00");
                endDate = format.parse(curTradeDay + " 15:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
