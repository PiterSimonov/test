package test.java.com.codenvy.testtask.qname;

import main.java.com.codenvy.testtask.qname.IllegalNameException;
import main.java.com.codenvy.testtask.qname.QName;
import main.java.com.codenvy.testtask.qname.QNameParser;
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
        assertEquals("_Pref-ix:some Name", qName.getAsString());
    }

    @Test(expected = IllegalNameException.class)
    public void testNullNameFault() throws IllegalNameException {
        qNameParser.parse(null);
    }

    @Test(expected = IllegalNameException.class)
    public void testNoNameFault() throws IllegalNameException {
        qNameParser.parse("");
    }

    @Test(expected = IllegalNameException.class)
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

}
