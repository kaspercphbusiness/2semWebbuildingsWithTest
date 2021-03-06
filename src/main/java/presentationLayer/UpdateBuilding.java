/*

 */
package presentationLayer;

import domain.Building;
import domain.DomainFacade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
UpdateBuilding handles post from the form updateBuilding in editbuilding jsp page.

![](UpdateServlet.png)
 
@uml UpdateServlet.png
editbuilding.jsp -> 
 */
@WebServlet( name = "updateBuilding", urlPatterns = { "/updateBuilding" } )
public class UpdateBuilding extends HttpServlet {

    /**
     Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     methods.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        response.setContentType( "text/html;charset=UTF-8" );
        request.setCharacterEncoding( "UTF-8" );
        //try ( PrintWriter out = response.getWriter() ) {
        String action = request.getParameter( "action" );
        if ( "Submit".equals( action ) ) {
            store( request, response );
        } else {
            System.out.println( "Cancel" );
        }
        forward( request, response, "buildings.jsp" );
        //}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     Handles the HTTP <code>GET</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     Handles the HTTP <code>POST</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     Returns a short description of the servlet.

     @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void forward( HttpServletRequest req, HttpServletResponse res, String path ) throws IOException, ServletException {
        //ServletContext sc = getServletContext();
        RequestDispatcher rd = req.getRequestDispatcher( "/" + path );
        rd.forward( req, res );
    }

    private void store( HttpServletRequest request, HttpServletResponse response ) {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        String street = request.getParameter( "street" );
        int zip = Integer.parseInt( request.getParameter( "zip" ) );
        String city = request.getParameter( "city" );
        String contact = request.getParameter( "contact" );
        String phone = request.getParameter( "phone" );
        Building b = new Building( id, street, zip, city, contact, phone );
        DomainFacade.getFacade().updateBuilding( b );
    }
}
