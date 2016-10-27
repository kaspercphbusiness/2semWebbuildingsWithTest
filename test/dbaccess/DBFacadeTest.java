package dbaccess;

import domain.Building;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kasper
 */
public class DBFacadeTest {
    
    public DBFacadeTest() {
    }
    
    private Connection testDatabase;
    private static String USER = "javatester";
    private static String USERPW = "testogeksperimenter=21coolstuf";
    private static String DBNAME = "buildingsTest";
    private static String HOST = "46.101.253.149";
    
    DBFacade facade;
    
    @Before
    public void setUp() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName("com.mysql.jdbc.Driver");
            
            testDatabase =  DriverManager.getConnection(url, USER, USERPW);
            try( Statement stmt = testDatabase.createStatement()){
                stmt.execute( "drop table if exists building");
                stmt.execute( "create table building like testbuilding");
                stmt.execute( "insert into building select * from testbuilding");
            }
            facade = new DBFacade(testDatabase );
            
        } catch ( ClassNotFoundException | SQLException ex ) {
            testDatabase = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );;
        }
    }        
     
    
    
    @Test
    public void testSetUpOK(){
        System.out.println( "SetUpOK" );
        assertNotNull("Setup failed", testDatabase);
    }

    /**
     * Test of getBuildings method, of class DBFacade.
     */
    @Test
    public void testGetBuildings_0args() {
        System.out.println( "getBuildings" );
        int expResultSize = 5;
        List<Building> result = facade.getBuildings();
        assertEquals( expResultSize, result.size() );
    }

    /**
     * Test of getBuildings method, of class DBFacade.
     */
    @Test
    public void testGetBuildings_int() {
        System.out.println( "getBuildings" );
        int buildingID = 0;
        DBFacade instance = null;
        Building expResult = null;
        Building result = instance.getBuildings( buildingID );
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of updateBuilding method, of class DBFacade.
     */
    @Test
    public void testUpdateBuilding() {
        System.out.println( "updateBuilding" );
        Building b = null;
        DBFacade instance = null;
        instance.updateBuilding( b );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }
    
}
