package domain;

import dbaccess.DBFacade;
import java.util.List;
import randomdata.Generator;

/**
 * The purpose of DomainFacade is to provide a way for the presentation layer to
 * access the domain model
 *
 * @author kasper
 */
public class DomainFacade {

    public static List<Building> getBuildings() {
        //return Generator.randomBuildings(100);
        return DBFacade.getBuildings();
    }

    public static Building getBuilding( int id ) {
        return DBFacade.getBuildings( id );
    }

    public static void updateBuilding( Building b ) {
        DBFacade.updateBuilding( b );
    }
}
 