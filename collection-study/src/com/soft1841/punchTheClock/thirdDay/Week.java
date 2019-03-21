package com.soft1841.punchTheClock.thirdDay;

import java.util.Scanner;

 enum Week {
    Sunday("星期天"),
    Monday("星期一"),
    Tuesday("星期二"),
    Wednesday("星期三"),
    Thursday("星期四"),
    Friday("星期五"),
    Saturday("星期六");
    String weekName;
    Week(String weekName){
        this.weekName=weekName;
    }
    public String getWeekName(){
        return weekName;
    }
    //定义一个静态方法，根据一个简称得到完整的星期名称
    public static Week getResult(String input){
        switch (input){
            case "sun":
                return  Week.Sunday;
            case "mon":
                return Week.Monday;
            case "thus":
                return Week.Tuesday;
            case "wed":
                return Week.Wednesday;
            case  "thur":
                return Week.Thursday;
            case  "fri":
                return Week.Friday;
            case  "sat":
                return Week.Saturday;
            default:
                return Week.Sunday;
        }
    }
}
class EnumTest{
    public static void main(String[] args) {
       Week week[] = Week.values();
       for (Week w : week){
           Scanner scanner = new Scanner(System.in);
           Week week1 =Week.getResult(scanner.next());
           System.out.println(w+"- -"+w.getWeekName());
       }
    }
}
