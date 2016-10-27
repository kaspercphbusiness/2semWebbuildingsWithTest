package dbaccess;

import domain.Building;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of DBFacade is to provide an encapsulated access to the database
 * (No SQL outside of the data-layer)
 *
 * @author kasper
 */
public class DBFacade {

    public static List<Building> getBuildings() {
        String sql = "SELECT id,street,contactName,zip,city,contactPhone "
                + "FROM building";
        List<Building> buildings = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();
                Statement stmt = con.createStatement() ) {
            ResultSet res = stmt.executeQuery( sql );
            while ( res.next() ) {
                int id = res.getInt( "id" );
                String street = res.getString( "street" );
                String name = res.getString( "contactName" );
                int zip = res.getInt( "zip" );
                String city = res.getString( "city" );
                String phone = res.getString( "contactPhone" );
                buildings.add( new Building( id, street, zip, city, name, phone ) );
            }
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println( "Element not gotten: " + ex.getMessage() );
        }
        return buildings;
    }

    public static Building getBuildings( int buildingID ) {
        String sql = "SELECT id,street,contactName,zip,city,contactPhone "
                + "FROM building "
                + "WHERE id=?";
        try ( Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement( sql ) ) {
            stmt.setInt( 1, buildingID);
            ResultSet res = stmt.executeQuery();
            if ( res.next() ) {
                String street = res.getString( "street" );
                String name = res.getString( "contactName" );
                int zip = res.getInt( "zip" );
                String city = res.getString( "city" );
                String phone = res.getString( "contactPhone" );
                return new Building( buildingID, street, zip, city, name, phone );
            }
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println( "Element not gotten: " + ex.getMessage() );
        }
        return null;
    }

    public static void updateBuilding( Building b ) {
/* UPDATE table_name
SET column1=value1,column2=value2,...
WHERE some_column=some_value;
*/
        String sql = "UPDATE building "
                + "SET street=?,"
                + "contactName=?,"
                + "zip=?,"
                + "city=?,"
                + "contactPhone=? "
                + "WHERE id=?";
        try ( Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement( sql ) ) {
            stmt.setString( 1, b.getAddress() );
            stmt.setString( 2, b.getContactPerson() );
            stmt.setInt( 3, b.getZip() );
            stmt.setString( 4, b.getCity() );
            stmt.setString( 5, b.getContactPhone() );
            stmt.setInt( 6, b.getId());
            int rowsAffected = stmt.executeUpdate();
            if ( rowsAffected > 0 ) {
                System.out.println( "Element inserted" );
            } else {
                System.out.println( "No change" );
            }
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println( "Element not inserted: " + ex.getMessage() );
        }
    }
}
