package com.atguigu;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * created by Administrator on 2021/5/1
 */
public class TestTimeApi {

    @Test
    public void test(){
        //hahaha heheheheh222
        //aaa
		//mm
	//xixi    
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2018, 1, 2, 20, 10, 15);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        int monthValue = ldt.getMonthValue();
        System.out.println(monthValue);

    }


    @Test
    public void test2(){
        Instant ins = Instant.now();

        System.out.println(ins);

        OffsetDateTime offsetDateTime = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        long epochSecond = offsetDateTime.toEpochSecond();
        System.out.println(epochSecond);

        Instant ins2 = Instant.ofEpochMilli(60);
        System.out.println(ins2);

    }

    @Test
    public void test3() throws InterruptedException {

        Instant ins1 = Instant.now();

        Thread.sleep(1000);
        Instant ins2 = Instant.now();

        Duration duration = Duration.between(ins1, ins2);
        System.out.println(duration);
        System.out.println(duration.toMillis());

        LocalTime localTime = LocalTime.now();
        Thread.sleep(2000);
        LocalTime localTime1 = LocalTime.now();
        System.out.println(Duration.between(localTime,localTime1).toMillis());

    }

    @Test
    public void test4(){

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2021, 5, 28);
        System.out.println(Period.between(localDate,localDate1).getDays());

    }


    //时间较正器
    @Test
    public void test5(){
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt1 = ldt.withDayOfMonth(10);
        System.out.println(ldt1);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义
        LocalDateTime ldt5 = ldt.with(temporal -> {
            LocalDateTime ldt4 = (LocalDateTime) temporal;
            DayOfWeek dayOfWeek = ldt4.getDayOfWeek();
            if (DayOfWeek.FRIDAY.equals(dayOfWeek)) {
                return ldt4.plusDays(3);
            } else if (DayOfWeek.SATURDAY.equals(dayOfWeek)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }

        });
        System.out.println(ldt5);


    }


    //时间格式化
    @Test
    public void test6(){

        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate2 = ldt.format(dtf2);
        System.out.println(strDate2);

        LocalDateTime ldt3 = ldt.parse(strDate2, dtf2);
        System.out.println(ldt3);


    }



    //带时区操纵的时间api
    @Test
    public void test7(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    @Test
    public void test8(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Volgograd"));
        System.out.println(ldt);

        ZonedDateTime zonedDateTime = ldt.atZone(ZoneId.of("Europe/Volgograd"));
        System.out.println(zonedDateTime);

    }






}
