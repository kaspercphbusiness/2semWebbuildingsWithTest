package domain;

import dbaccess.DBConnection;
import dbaccess.DBFacade;
import java.sql.Connection;
import java.util.List;

/**
 * The purpose of DomainFacade is to provide a way for the presentation layer to
 * access the domain model
 *
 * @author kasper
 */
public class DomainFacade {

    private static DomainFacade facade;

    public static DomainFacade getFacade() {
        if ( facade == null ) {
            facade = new DomainFacade();
        }
        return facade;
    }

    public static void setFacade( DomainFacade aFacade ) {
        facade = aFacade;
    }

    public List<Building> getBuildings() {
        Connection con = DBConnection.getConnection();
        DBFacade dbf = new DBFacade( con );
        return dbf.getBuildings();
    }

    public Building getBuilding( int id ) {
        Connection con = DBConnection.getConnection();
        DBFacade dbf = new DBFacade( con );
        return dbf.getBuildings( id );
    }

    public void updateBuilding( Building b ) {
        Connection con = DBConnection.getConnection();
        DBFacade dbf = new DBFacade( con );
        dbf.updateBuilding( b );
    }
}
