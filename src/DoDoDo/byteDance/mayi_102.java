package DoDoDo.byteDance;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 笔试题1--交易日管理
 *
 * 背景描述：
 * 在金融业务中，经常涉及到交易日期的计算，交易日和自然日是有区别的，比如法定节假日，周末，都是不能交易的，我们叫非交易日，允许交易的日我们称之为交易日。
 * 交易日每天也不是24小时，比如中国股市的股票交易时间在每个交易日的[AM9:30-11:30) 和 [PM13:00-15:00)
 * 为了满足7*24小时服务，我们对用户提供的服务在非交易日或是非交易时段也是有支持的，所以将非交易时段产生的业务，它的交易日会算到下一个最近交易时段的交易日中，
 * 为了表述方便，我们用T+0表示当前交易日，T+1表示下一个交易日。D+0表示当天自然日，D+1表示下一个自然日，以此类推可能会有：D+n，D-n T+n，T-n等这样的日期表述方式。
 * 举例说明：20160701 20160704 20160705 是交易日，交易日的交易时间是[AM9:30-11:30) 和 [PM13:00-15:00),20160702和20160703是非交易日，则 20160701上午8点的交易日是20160701 ，20160701下午5点的交易日则是 20160704 ，用T+0标示某个时间的当前交易日，如20160701下午5点的T+0为20160704，T+1为20160705。
 *
 * 编程要求：
 * 写一个交易日期的计算工具类：
 * 1、根据交易日历初始化交易日工具
 * 2、给定任意时间，返回给定时间的T+n交易日。
 *
 * //: TODO 可自行定义需要的变量
 * 工具初始化，初始化的目的是让工具具备更加合适各的数据结构，方便计算提高效率
 * tradeDayList: 包含一年内所有的交易日起，格式如：20160701 20160704 20160705，非交易日20160702 20160703不在其中.
 * public void init(List tradeDayList){
 * }
 *
 *
 * 给定任意时间，返回给定时间的T+n交易日
 * time:给定要计算的时间; offsetDays:交易日便宜量，offsetDays可以为负数，表示T-n的计算。
 * public String getTradeDay(Date time,int offsetDays){
 *     //: TODO 完成此处的代码
 * }
 *
 */
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
