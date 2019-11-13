import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.net.URLConnection;

public class Idz8App {
    public static void main(String[] args) {
        final String URL_PATH = "http://belgazprombank.by/export_courses.php";

        try {
            URL url = new URL(URL_PATH);
            URLConnection conn = url.openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());

            NodeList nodes = doc.getElementsByTagName("rate");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                NodeList title = element.getElementsByTagName("rate");
                Element line = (Element) title.item(0);
                System.out.println(line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
