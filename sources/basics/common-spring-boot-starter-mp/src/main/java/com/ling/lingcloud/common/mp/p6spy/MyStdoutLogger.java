package com.ling.lingcloud.common.mp.p6spy;


import com.p6spy.engine.spy.appender.StdoutLogger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2024/4/30 by 钟舒艺
 *
 * @author 钟舒艺
 */
public class MyStdoutLogger extends StdoutLogger {

    @Override
    public void logText(String text) {
        Pattern pattern = Pattern.compile("#(.*?) \\| took (.*?) \\| (.*?) \\| connection (.*?)\\| url (.*?)\n(.*)\n(.*)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.err.println("-------------------------------------p6spyLog---------------------------------------");
            System.err.println("ID: " + matcher.group(1));
            System.err.println("Execution Time: " + matcher.group(2));
            System.err.println("Statement Type: " + matcher.group(3));
            System.err.println("Connection ID: " + matcher.group(4));
            System.err.println("URL: " + matcher.group(5));
            System.err.println("SQL Statement 1: " + matcher.group(6));
            System.err.println("SQL Statement 2: " + matcher.group(7));
            System.err.println("-----------------------------------------------------------------------------------");

        }
    }
}
