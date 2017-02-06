package task16;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import _04_xml.dom_example.entities.Address;
import _04_xml.dom_example.entities.Student;

//https://docs.oracle.com/javase/tutorial/jaxb/intro/index.html
public class Main {
	public static void main(String[] args) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		StudentsHandler sh = new StudentsHandler();
		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse(new File("src/task16/_01_students.xml"), sh);
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sh.getStudents().forEach((student)->{
			System.out.println(student.toString());
		});
	}
}

class StudentsHandler extends DefaultHandler {
	private List<Student> students;
private boolean isAddress = false;
private boolean isStud = false;
private boolean isName = false;
private boolean isPhone = false;
private boolean isCountry = false;
private boolean isStreet = false;
private boolean isCity = false;

private Student s;
private Address a;

private String  _name;
private long    _phone;

private Address _address;
private String _country;
private String _city;
private String _street;

private String  _login;
private String  _faculty;
    
	public StudentsHandler() {
		super();
		students = new ArrayList<>();
	
}
	

	public List<Student> getStudents() {
		return students;
	}


	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
		System.out.println("resolveEntity");
		return super.resolveEntity(publicId, systemId);
	}

	@Override
	public void notationDecl(String name, String publicId, String systemId) throws SAXException {
		System.out.println("notationDecl");
		super.notationDecl(name, publicId, systemId);
	}

	@Override
	public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName)
			throws SAXException {
		System.out.println("unparsedEntityDecl");
		super.unparsedEntityDecl(name, publicId, systemId, notationName);
	}

	@Override
	public void setDocumentLocator(Locator locator) {
	//	System.out.println("setDocumentLocator");
		super.setDocumentLocator(locator);
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("StartDoc");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDoc");
		super.endDocument();
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		System.out.println("startPrefixMapping");
		super.startPrefixMapping(prefix, uri);
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println("endPrefixMapping");
		super.endPrefixMapping(prefix);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.println("StartElement uri="+uri+"; localName="+localName+"; qName="+qName+"; attributes="+attributes.getLength());
		super.startElement(uri, localName, qName, attributes);

		
		if (qName.equals("student")){
			s= new Student();
			for (int i = 0;i<attributes.getLength();i++) {
				//System.out.println(attributes.getQName(i)+";"+ attributes.getValue(i));
				if (attributes.getQName(i).equals("login")){s.setLogin(attributes.getValue(i));}
				if (attributes.getQName(i).equals("faculty")){s.setFaculty(attributes.getValue(i));}
			}
			isStud = true;}
		if (qName.equals("address")){
			a= new Address();
			isAddress = true;
		}
		if (qName.equals("name")){isName = true;}
		if (qName.equals("phone")){isPhone = true;}
		
		if (qName.equals("country")){isCountry = true;}
		if (qName.equals("city")){isCity = true;}
		if (qName.equals("street")){isStreet = true;}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("endElement uri="+uri+"; localName="+localName+"; qName="+qName);
		super.endElement(uri, localName, qName);
		if (qName.equals("student")){isStud = false;students.add(s);}
		if (qName.equals("address")){isAddress = false;s.setAddress(a);}
		
		if (qName.equals("name")){isName = false;}
		if (qName.equals("phone")){isPhone = false;}
		
		if (qName.equals("country")){isCountry = false;}
		if (qName.equals("city")){isCity = false;}
		if (qName.equals("street")){isStreet = false;}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//System.out.println("characters start from "+start+"; length "+length);
		String stroka =new String(ch,start,length);
		if(isName){s.setName(stroka);}
		if(isPhone){s.setPhone(Long.parseLong(stroka));}
		if(isCountry){a.setCountry(stroka);}
		if(isCity){a.setCity(stroka);}
		if(isStreet){a.setStreet(stroka);}
		//System.out.println(stroka);
		super.characters(ch, start, length);
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		System.out.println("ignorableWhitespace");
		super.ignorableWhitespace(ch, start, length);
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		System.out.println("processingInstruction");
		super.processingInstruction(target, data);
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		System.out.println("skippedEntity");
		super.skippedEntity(name);
	}

	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("warning");
		super.warning(e);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("error");
		super.error(e);
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("fatalError");
		super.fatalError(e);
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode");
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("clone");
		return super.clone();
	}

	@Override
	public String toString() {
		System.out.println("toString");
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
		super.finalize();
	}
	
}
