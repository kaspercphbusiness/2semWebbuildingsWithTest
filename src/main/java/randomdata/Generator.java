package randomdata;

import domain.Building;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of Generator is to provide methods to aid in generation of random
 * data
 *
 * @author kasper
 */
public final class Generator {

    public static List<Building> randomBuildings( int N ) {
        List<Building> buildings = new ArrayList<>();
        for ( Person p : PersonGenerator.persons( N ) ) {
            Address addr = AddressGenerator.address();
            String street = addr.getAddress();
            int zip = Integer.parseInt( addr.getZip() );
            String city = addr.getCity();
            String name = p.getName();
            String phone = p.getPhoneNo();
            Building building = new Building( 7, street, zip, city, name, phone );
            buildings.add( building );
        }
        return buildings;
    }

}
