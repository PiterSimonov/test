package com.codenvy.testtask.qname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QNameParser {
    private static final String LOCAL_NAME_REGEX = "\\A([\\p{ASCII}&&[^/:'\\u0022\\s\\Q[]*|\\E]]+\\u0020?" +
            "[\\p{ASCII}&&[^/:'\\u0022\\s\\Q[]*|\\E]]+)+(?!\\u0020)\\z";
    private static final String SIMPLE_NAME_REGEX = "\\A(\\.?[\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+|" +
            "[\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+\\.?|" +
            "([\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+\\u0020?" +
            "[\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+)+)(?!\\u0020)\\z";
    private static final String PREFIX_REGEX = "\\A(?!((X|x)(M|m)(L|l)))[\\p{Alpha}_]+[\\p{Alnum}\\u002E_-]*$";
    private static final Pattern LOCAL_NAME_PATTERN = Pattern.compile(LOCAL_NAME_REGEX);
    private static final Pattern SIMPLE_NAME_PATTERN = Pattern.compile(SIMPLE_NAME_REGEX);
    private static final Pattern PREFIX_PATTERN = Pattern.compile(PREFIX_REGEX);

    public QName parse(String name) throws IllegalNameException {
        String prefix = null;
        String qName;
        
        if ((name == null) || (name.equals(""))) {
            throw new IllegalNameException("empty name");
        }
        if (name.contains(":")) {
            String[] result = name.split(":");
            if (result.length != 2) {
                throw new IllegalNameException("invalid name");
            }
            if ((result[0].length() != 0)
                    && (isValidName(result[0], PREFIX_PATTERN))
                    && (isValidName(result[1], LOCAL_NAME_PATTERN))) {
                prefix = result[0];
                qName = result[1];
            } else {
                throw new IllegalNameException("invalid name");
            }
        } else if (isValidName(name, SIMPLE_NAME_PATTERN)) {
            qName = name;
        } else {
            throw new IllegalNameException("invalid name");
        }

        return new QName(prefix, qName);
    }

    private boolean isValidName(String name, Pattern pattern) {
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    
}
