import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        System.out.println(StringUtils.swapCase("hello cat"));

//        String str = "create external table my(aa) location 'hdfs://data/gamein';select * from 哈哈哈(bb);create external table you(xx);";
////        String str = "ab]cd[ef]gh[ij[kl]mn[op]qr]st[uv";
////        String reg = "\\((.*?)\\)";
//        String reg = "table (.*?)\\(";
////        String reg = "\\[(.*?)]";
//        Pattern compile = Pattern.compile(reg);
//        Matcher matcher = compile.matcher(str);
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//        }

//
//        String log = "20211212 [Main] 192.168.2.1 China CQ";
//        String reg2 = "\\d{8} \\[Main] (.*) (.*) (.*)";
//        Pattern compile2 = Pattern.compile(reg2);
//        Matcher matcher2 = compile2.matcher(log);
//        while (matcher2.find()) {
//            System.out.println(matcher2.group(1));
//            System.out.println(matcher2.group(2));
//            System.out.println(matcher2.group(3));
//        }
//        System.out.println(Pattern.matches(reg2, log));
//        String s = "54adf4545sdf45sdf46ad8fa31sdf33";
//        Matcher matcher = Pattern.compile("[0-9]+").matcher(s);
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }

        String str = "123123你a好啊啊啊aa123123";
        String regEx = "[\u4E00-\u9FA5\uf900-\ufa2d]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
