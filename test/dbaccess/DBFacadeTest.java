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
        // '110','Louis Pios Gade 12','Antonina Lund','4100',' Ringsted','4613-8808'
        int buildingID = 110;
        String expResult = "Louis Pios Gade 12";
        Building result = facade.getBuildings( buildingID );
        assertEquals( expResult, result.getAddress() );
    }

    /**
     * Test of updateBuilding method, of class DBFacade.
     */
    @Test
    public void testUpdateBuilding() {
        System.out.println( "updateBuilding" );
        // 160, Heisesgade 94, Lars Paulsen, 2640,  Hedehusene, 3184-3141
        // Change phone number
        Building b = new Building(160, "Heisesgade 94", 2640, "Hedehusene",
                "Lars Paulsen", "3100-3100");
        facade.updateBuilding( b );
        Building b2 = facade.getBuildings( 160);
        assertEquals( "3100-3100", b2.getContactPhone());
    }
    
}
