This is a project with QName class implementation (qualified name) and a parser for construct instances of QName

QName realizations:
String getPrefix (); - prefix
String getLocalName (); - the local name
String getAsString (); - full name ([prefix:] localName)

Parser realization:
QName parse (String name) throws IllegalNameException; - parses name and returns a QName. In the case of 
                       an invalid name  it will catch  IllegalNameException.
														 
String syntax for name(BNF format):
   name ::= simplename | prefixedname
   simplename ::=onecharsimplename | twocharsimplename | threeormorecharname
   prefixedname ::= prefix ':' localname
   localname ::= onecharlocalname |  twocharlocalname | threeormorecharname
   onecharsimplename ::= (* Any Unicode character except: '.', '/', ':', '[', ']', '*',
                           ''', '"', '|' or any whitespace character *)
   twocharsimplename ::= '.' onecharsimplename | onecharsimplename '.' |onecharsimplename onecharsimplename
   onecharlocalname ::= nonspace
   twocharlocalname ::= nonspace nonspace
   threeormorecharname ::= nonspace string nonspace
   prefix ::= (* Any valid XML Name *)
   string ::= char | string char
   char ::= nonspace | ' '
   nonspace ::= (* Any Unicode character except: '/', ':', '[', ']', '*', ''', '"', '|'
                             or any whitespace character *)

To build the project from the console you need (assuming installed Maven 4):
- Open the console
- Go to the folder with the project (using the "cd" command in the Windows console) that contains the file pom.xml
- Enter the command "mvn install"
Maven then compile the source code, launch the junit test and package the project to the jar file