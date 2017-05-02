/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import domain.Building;
import domain.DomainFacade;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author kasper
 */
public class UpdateBuildingTest {
    
    public UpdateBuildingTest() {
    }

    /**
     * Check that Servlet gathers the request arguments correctly and
     * builds a Building object which is passed on to Domain facade
     * @throws Exception 
     */
    @Test
    public void testProcessRequestSubmit() throws Exception {
        System.out.println( "processRequestSubmit" );
        HttpServletRequest request = mock( HttpServletRequest.class );
        HttpServletResponse response = mock( HttpServletResponse.class );
        DomainFacade df = mock(DomainFacade.class);
        when( request.getParameter( "action")).thenReturn( "Submit");

        when( request.getParameter( "id")).thenReturn( "110");
        when( request.getParameter( "street")).thenReturn( "Ligustervænget 4");
        when( request.getParameter( "zip")).thenReturn( "2830");
        when( request.getParameter( "city")).thenReturn( "Virum");
        when( request.getParameter( "contact")).thenReturn( "Petunia Potter");
        when( request.getParameter( "phone")).thenReturn( "7467-4222");
        
        RequestDispatcher rd = mock(RequestDispatcher.class);
        when( request.getRequestDispatcher( anyString() ))
                .thenReturn( rd );
        
        DomainFacade.setFacade( df );
        UpdateBuilding servlet = new UpdateBuilding();
        
        ArgumentCaptor<Building> bc = ArgumentCaptor.forClass(Building.class);
        
        // Call the processRequest method
        servlet.processRequest( request, response );
        
        verify( df, times(1)).updateBuilding( bc.capture() );
        assertEquals( "Petunia Potter", bc.getValue().getContactPerson());
    }

    /**
     * Check that Servlet forwards without storing if Cancel is pressed
     * @throws Exception 
     */
    @Test
    public void testProcessRequestCancel() throws Exception {
        System.out.println( "processRequestCancel" );
        HttpServletRequest request = mock( HttpServletRequest.class );
        HttpServletResponse response = mock( HttpServletResponse.class );
        DomainFacade df = mock(DomainFacade.class);
        when( request.getParameter( "action")).thenReturn( "Cancel");
        
        RequestDispatcher rd = mock(RequestDispatcher.class);
        when( request.getRequestDispatcher( anyString() ))
                .thenReturn( rd );
        
        DomainFacade.setFacade( df );
        UpdateBuilding servlet = new UpdateBuilding();
        
        // Call the processRequest method
        servlet.processRequest( request, response );
        
        verify( df, times(0)).updateBuilding( any(Building.class) );
        
    }
}
