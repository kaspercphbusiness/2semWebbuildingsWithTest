/**
 Encapsulates the database layer.
 The database is accessed through the BDFacade class. The DBConncection provides
 the database connection used for instantiating the DBFacace.

 Example showing how the getBuildings method is called.

 ![DBUsageDiagram](dbfacadeusage.png)

 @uml dbfacadeusage.png
 DomainLayer -> DBConnection: getConnection
 DomainLayer <-- DBConnection: aConnection
 DomainLayer -> DBFacade: new DBFacade( aConnection )
 DomainLayer <-- DBFacade: aFacade
 DomainLayer -> aFacade: getBuildings()\n(for example)
 DomainLayer <-- aFacade: List of Building
 */
package dbaccess;
