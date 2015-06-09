package com.codenvy.testtask.qname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QNameParser {


    static QName parse(String name) throws IllegalNameException {
        String prefix = null;
        String qName;
        if (name.equals("")) throw new IllegalNameException();
        if (name.contains(":")) {
            String[] result = name.split(":");
            if (result.length != 2) throw new IllegalNameException();
            if (result[0].length() != 0 && isPrefixValidXMLName(result[0]) && isLocalNameValid(result[1])) {
                prefix = result[0];
                qName = result[1];
            } else throw new IllegalNameException();
        }
        else if (isSimpleNameValid(name)) qName = name;
        else throw new IllegalNameException();

        return new QName(prefix, qName);
    }

    /**
     * The method checks the correct prefix according to XML syntax.<br/>
     * <p/>
     * XML elements must follow these naming rules:<br/>
     * - Element names are case-sensitive<br/>
     * - Element names must start with a letter or underscore<br/>
     * - Element names cannot start with the letters xml (or XML, or Xml, etc)<br/>
     * - Element names can contain letters, digits, hyphens, underscores, and periods<br/>
     * - Element names cannot contain spaces<br/>
     * - Any name can be used, no words are reserved (except xml).<br/>
     * SEE <a href="http://www.w3schools.com/xml/xml_elements.asp">trueLink</a>
     */
    private static boolean isPrefixValidXMLName(String prefix) {
        Pattern pattern = Pattern.compile("\\A(?!((X|x)(M|m)(L|l)))[\\p{Alpha}_]+[\\p{Alnum}\\u002E_-]*$");
        Matcher matcher = pattern.matcher(prefix);
        return matcher.matches();
    }

    private static boolean isLocalNameValid(String localName) {
        String nonSpace = "[\\p{ASCII}&&[^/:'\\u0022\\s\\Q[]*|\\E]]+";
        String regexName = nonSpace + "\\u0020?" + nonSpace;
        Pattern pattern = Pattern.compile("\\A(" + regexName + ")+(?!\\u0020)\\z");
        Matcher matcher = pattern.matcher(localName);
        return matcher.matches();
    }

    private static boolean isSimpleNameValid(String simpleName) {
        String nonSpace = "[\\p{ASCII}&&[^/:'\\u0022\\s\\Q.[]*|\\E]]+";
        String regexName = nonSpace + "\\u0020?" + nonSpace;
        Pattern pattern = Pattern.compile("\\A(\\.?" + nonSpace + "|" + nonSpace + "\\.?|(" + regexName + ")+)(?!\\u0020)\\z");
        Matcher matcher = pattern.matcher(simpleName);
        return matcher.matches();
    }


}
