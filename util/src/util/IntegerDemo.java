package util;

/**
 * Integer类的练习
 * @author 位哲武
 * 2019.3.12
 */

public class IntegerDemo {
//    public static void main(String[] args) {
//        int num = 31;
//        //调用Integer类的方法，将num进行进制转换
//        //二进制
//        String str1 = Integer.toBinaryString(num);
//        System.out.println("二进制：" + str1);
//        //十六进制
//        String str2 = Integer.toHexString(num);
//        System.out.println("十六进制：" + str2);
//        //八进制
//        String str3 = Integer.toOctalString(num);
//        System.out.println("八进制进制：" + str3);
//        //十五进制
//        String str4 = Integer.toString(num, 15);
//        System.out.println("十五进制：" + str4);
//    }


//    static char chs[] = new char[36];
//    static {
//        for(int i = 0; i < 10 ; i++) {
//            chs[i] = (char)('0' + i);
//        }
//        for(int i = 10; i < chs.length; i++) {
//            chs[i] = (char)('A' + (i - 10));
//        }
//    }
//    static String transRadix(String num, int fromRadix, int toRadix) {
//        int number = Integer.valueOf(num, fromRadix);
//        StringBuilder sb = new StringBuilder();
//        while (number != 0) {
//            sb.append(chs[number%toRadix]);
//            number = number / toRadix;
//        }
//        return sb.reverse().toString();
//
//    }
//    //测试
//    public static void main(String[] args) {
//        System.out.println(transRadix("10", 10, 2));
//    }

    private static String convert(int num,int radix){
        //创建一个StringBuffer,用来存放结果字串符
        StringBuffer stringBuffer = new StringBuffer();
        while (num !=0){
            //求出余数
            int remainder = num%radix;
            //更新被除数为商
            num = num/radix;
            //将余数转换为字符串，加入stringBuffer
            stringBuffer.append(String.valueOf(remainder));

        }
        //将结果串取余返回
        return stringBuffer.reverse().toString();
    }

}
