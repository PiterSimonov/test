<<<<<<< HEAD
package com.codenvy.testtask.qname;

=======
package test.java.com.codenvy.testtask.qname;

import main.java.com.codenvy.testtask.qname.IllegalNameException;
import main.java.com.codenvy.testtask.qname.QName;
import main.java.com.codenvy.testtask.qname.QNameParser;
>>>>>>> 1e01a236f7c36a898b87878c772293e9cb314c04
import org.junit.Assert;
import org.junit.Test;

public class QNameParserTest extends Assert {

    private QNameParser qNameParser = new QNameParser();

    @Test
    public void testSimpleName() throws IllegalNameException {
        QName qName = qNameParser.parse("normalSimpleName");
        assertEquals("normalSimpleName", qName.getLocalName());
        assertNull(qName.getPrefix());
        assertEquals("normalSimpleName", qName.getAsString());
    }

    @Test
    public void testPrefixedName() throws IllegalNameException {
        QName qName = qNameParser.parse("normalPrefix:someName");
        assertEquals("someName", qName.getLocalName());
        assertEquals("normalPrefix", qName.getPrefix());
        assertEquals("normalPrefix:someName", qName.getAsString());
    }

    @Test
    public void testPrefixedNameWithSpace() throws IllegalNameException {
        QName qName = qNameParser.parse("normalPrefix:some Name");
        assertEquals("some Name", qName.getLocalName());
        assertEquals("normalPrefix", qName.getPrefix());
        assertEquals("normalPrefix:some Name", qName.getAsString());
    }

    @Test
    public void testPrefixWithHyphenAndUnderscore() throws IllegalNameException {
        QName qName = qNameParser.parse("_Pref-ix:someName");
        assertEquals("someName", qName.getLocalName());
        assertEquals("_Pref-ix", qName.getPrefix());
<<<<<<< HEAD
        assertEquals("_Pref-ix:someName", qName.getAsString());
    }

    @Test(expected = IllegalNameException.class)
    public void testNullNameFailed() throws IllegalNameException {
=======
        assertEquals("_Pref-ix:some Name", qName.getAsString());
    }

    @Test(expected = IllegalNameException.class)
    public void testNullNameFault() throws IllegalNameException {
>>>>>>> 1e01a236f7c36a898b87878c772293e9cb314c04
        qNameParser.parse(null);
    }

    @Test(expected = IllegalNameException.class)
<<<<<<< HEAD
    public void testNoNameFailed() throws IllegalNameException {
=======
    public void testNoNameFault() throws IllegalNameException {
>>>>>>> 1e01a236f7c36a898b87878c772293e9cb314c04
        qNameParser.parse("");
    }

    @Test(expected = IllegalNameException.class)
<<<<<<< HEAD
    public void testColonWithoutPrefixFailed() throws IllegalNameException {
        qNameParser.parse(":name");
    }

    @Test(expected = IllegalNameException.class)
    public void testSimpleNoNameWithDotFailed() throws IllegalNameException {
        qNameParser.parse(".");
    }

    @Test(expected = IllegalNameException.class)
    public void testSimpleNoNameWithDoubleDotFailed() throws IllegalNameException {
        qNameParser.parse("..");
    }

    @Test(expected = IllegalNameException.class)
    public void testPrefixedNoNameFailed() throws IllegalNameException {
        qNameParser.parse("prefix:");
    }

    @Test(expected = IllegalNameException.class)
    public void testSpaceBeforeSimpleNameFailed() throws IllegalNameException {
        qNameParser.parse(" simpleName");
    }

    @Test(expected = IllegalNameException.class)
    public void testSpaceBeforePrefixWithNameFailed() throws IllegalNameException {
        qNameParser.parse(" prefix:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testSpaceBeforeLocalNameFailed() throws IllegalNameException {
        qNameParser.parse("prefix: name");
    }

    @Test(expected = IllegalNameException.class)
    public void testSpaceAfterLocalNameFailed() throws IllegalNameException {
        qNameParser.parse("prefix:name ");
    }

    @Test(expected = IllegalNameException.class)
    public void testSpaceInPrefixWithNameFailed() throws IllegalNameException {
        qNameParser.parse("pre fix:name");
    }

    @Test(expected = IllegalNameException.class)
    public void testSimpleNameWithSlashFailed() throws IllegalNameException {
        qNameParser.parse("name/otherName");
    }

    @Test(expected = IllegalNameException.class)
    public void testSimpleNameWithSquareBracketsFailed() throws IllegalNameException {
        qNameParser.parse("name[otherName");
    }

    @Test(expected = IllegalNameException.class)
    public void testPrefixedNameWithColonFailed() throws IllegalNameException {
        qNameParser.parse("prefix:other:Name");
    }
=======
    public void testColonWithoutPrefixFault() throws IllegalNameException {
        qNameParser.parse(":name");
    }
//
//    .
//    ..
//    prefix:
//    <пробел>name
//    <пробел>prefix:name
//    prefix: <пробел>name
//    prefix:name<пробел>
//    pre fix:name
//    name/name
//    name[name
//    prefix:name:name
>>>>>>> 1e01a236f7c36a898b87878c772293e9cb314c04

}
