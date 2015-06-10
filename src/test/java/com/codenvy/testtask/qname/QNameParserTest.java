package com.codenvy.testtask.qname;

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
        assertEquals("_Pref-ix:someName", qName.getAsString());
    }

    @Test(expected = IllegalNameException.class)
    public void testNullNameFailed() throws IllegalNameException {
        qNameParser.parse(null);
    }

    @Test(expected = IllegalNameException.class)
    public void testNoNameFailed() throws IllegalNameException {
        qNameParser.parse("");
    }

    @Test(expected = IllegalNameException.class)
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

}
