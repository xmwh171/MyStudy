package com.zhou.base.Test;

import java.io.LineNumberReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/4/10 12:35
 */
public class HwQ_1 {

    private static final String tmpYu = "&";
    private static final String tmpZkh = "{";
    private static final String tmpYkh = "}";
    private static final String tmpDengYu = "=";

    public String replace(String text) throws Exception {
        String result = text;
        List<String> lines = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        Reader reader = new StringReader(text);
        LineNumberReader lineNumberReader = new LineNumberReader(reader);
        String line = lineNumberReader.readLine();
        while(line != null){
            lines.add(line);
            String[] splitStr = line.split(tmpDengYu);
            map.put(splitStr[0],splitStr[1]);
            line = lineNumberReader.readLine();
        }
        String lastLine = lines.get(lines.size()-1);
        result = replaceMethod(map,lastLine.substring(lastLine.indexOf(tmpDengYu)+1,lastLine.length()));
        return result;
    }

    private String replaceMethod(Map<String,String> map,String str){
        while(str.contains(tmpYu)){
            String subStr = str.substring(str.indexOf(tmpYu),str.indexOf(tmpYkh)+1);
            String repStr = map.get(subStr.replace(tmpYu+tmpZkh,"").replace(tmpYkh,""));
            str = str.replace(subStr,repStr);
        }
        return str;
    }

    /**
     * 输入：
     * xxx=sss/ooo/&{ttt}/uuu" +
     " ttt=www" +
     " eee=jjj" +
     " yyy=ggg/ppp/&{xxx}/ttt/&{eee}
     输出： ggg/ppp/sss/ooo/www/uuu/ttt/jjj
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        HwQ_1 replaceStr = new HwQ_1();
        System.out.println(replaceStr.replace("xxx=sss/ooo/&{ttt}/uuu\n" +
                "ttt=www\n" +
                "eee=jjj\n" +
                "yyy=ggg/ppp/&{xxx}/ttt/&{eee}"));
    }
}
