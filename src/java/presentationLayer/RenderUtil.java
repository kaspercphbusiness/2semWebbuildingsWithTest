package presentationLayer;

import domain.Building;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspWriter;

/**
 * The purpose of RenderUtil is to provide a number of static methods which will
 * help keep the JSP pages less cluttered
 *
 * @author kasper
 */
public class RenderUtil {

    public static void renderBuildingsTable( JspWriter out, List<Building> buildings )
            throws IOException {
        if ( buildings.isEmpty() ) {
            return;
        }

        out.println( "<table>" );
        out.println( "<tr><th>Address</th><th>Zip</th><th>City</th><th>Contact</th><th>Phone</th></tr>" );
        for ( Building b : buildings ) {
            String addr = "<a href=\"editbuilding.jsp?buildingid=" + b.getId() + "\">" + b.getAddress() + "</a>";
            String zip = String.valueOf( b.getZip() );
            String city = b.getCity();
            String contact = b.getContactPerson();
            String phone = b.getContactPhone();
            String htmlTemplate = "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>";
            out.println( String.format( htmlTemplate, addr, zip, city, contact, phone ) );
        }
        out.println( "</table>" );
    }
    
}
