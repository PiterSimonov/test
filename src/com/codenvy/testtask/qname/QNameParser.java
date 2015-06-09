package com.codenvy.testtask.qname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QNameParser {
    private final String LOCAL_NAME_REGEX = "\\A([\\p{ASCII}&&[^/:'\\u0022\\s\\Q[]*|\\E]]+\\u0020?" +
            "[\\p{ASCII}&&[^/:'\\u0022\\s\\Q[]*|\\E]]+)+(?!\\u0020)\\z";
    private final String SIMPLE_NAME_REGEX = "\\A(\\.?[\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+|" +
            "[\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+\\.?|" +
            "([\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+\\u0020?" +
            "[\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+)+)(?!\\u0020)\\z";
    private final String PREFIX_REGEX = "\\A(?!((X|x)(M|m)(L|l)))[\\p{Alpha}_]+[\\p{Alnum}\\u002E_-]*$";

    QName parse(String name) throws IllegalNameException {
        String prefix = null;
        String qName;
        if (name.equals("")) throw new IllegalNameException("empty name");
        if (name.contains(":")) {
            String[] result = name.split(":");
            if (result.length != 2) throw new IllegalNameException("invalid name");
            if (result[0].length() != 0 && isValidName(result[0], PREFIX_REGEX) && isValidName(result[1], LOCAL_NAME_REGEX)) {
                prefix = result[0];
                qName = result[1];
            } else throw new IllegalNameException("invalid name");
        } else if (isValidName(name, SIMPLE_NAME_REGEX)) qName = name;
        else throw new IllegalNameException("invalid name");

        return new QName(prefix, qName);
    }

    private boolean isValidName(String name, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

}
