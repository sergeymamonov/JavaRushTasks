package com.javarush.task.task33.task3309;

//import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Комментарий внутри xml
*/
public class Solution {
    /*
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        Writer stringWriter = new StringWriter();
        marshaller.marshal(obj, new XMLSerializer(stringWriter, null) {



            private final Pattern CDATA_CHARS = Pattern.compile("[<>&\\\"\\']");

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                boolean hasCDATA = CDATA_CHARS.matcher(new String(ch, start, length)).find();
                if (hasCDATA) super.startCDATA();
                super.characters(ch, start, length);
                if (hasCDATA) super.endCDATA();
            }
        });

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = documentBuilderFactory.newDocumentBuilder().parse
                (new InputSource(new StringReader(stringWriter.toString())));

        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeName().equals(tagName)) {
                currentNode.getParentNode().insertBefore(document.createComment(comment), currentNode);
                currentNode.getParentNode().insertBefore(document.createTextNode("\n"), currentNode);
            }
        }

        stringWriter = new StringWriter();

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

        return stringWriter.toString();
    }

     */

    public static void main(String[] args) {
    }
}
