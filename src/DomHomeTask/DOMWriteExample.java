package DomHomeTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import _04_xml.dom_example.entities.Address;
import _04_xml.dom_example.entities.Student;

public class DOMWriteExample {
	////////////////
	private static final boolean _STANDALONEOPTION= false;
	////////////////
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		Address a = new Address("UA", "DP", "KM");
		students.add(new Student("Vasya Pupevich", 332332, a, "vas", "design"));
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			if(_STANDALONEOPTION){doc.setXmlStandalone(true);}
			Element rootElement = doc.createElement("students");
			doc.appendChild(rootElement);

			students.forEach((student) -> {
				Element studentElement = doc.createElement("student");
				studentElement.setAttribute("login", student.getLogin());
				//studentElement.setIdAttribute("login", true);
				studentElement.setAttribute("faculty", student.getFaculty());
				
				Element nameElement = doc.createElement("name");
				nameElement.setTextContent(student.getName());
				studentElement.appendChild(nameElement);
				
				Element phoneElement = doc.createElement("phone");
				phoneElement.setTextContent(String.valueOf(student.getPhone()));
				studentElement.appendChild(phoneElement);
				
				Element addressElement = doc.createElement("address");
					Element countryElement = doc.createElement("country");
					countryElement.setTextContent(String.valueOf(student.getAddress().getCountry()));
					addressElement.appendChild(countryElement);
					
					Element cityElement = doc.createElement("city");
					cityElement.setTextContent(String.valueOf(student.getAddress().getCity()));
					addressElement.appendChild(cityElement);
					
					Element streetElement = doc.createElement("street");
					streetElement.setTextContent(String.valueOf(student.getAddress().getStreet()));
					addressElement.appendChild(streetElement);
					
				studentElement.appendChild(addressElement);
				//TODO Add address here Home Work
				
				rootElement.appendChild(studentElement);
			});
			
			
			//TODO Write here

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("studentsByIgor.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

}
