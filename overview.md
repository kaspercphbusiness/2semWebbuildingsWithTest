This solution is just a sample solution showing information from a single 
database table using jsp technology.

It is build as a classic three layer architecture

- Presentation
- Domain
- Storage

![architecture](architecture.png)

@uml architecture.png
namespace System {
package "Presentation layer"  as presentation {
  class buildings <<jsp>>
  class editbuildings<<jsp>>

  class RenderUtil 
  class UpdateBuilding <<Servlet>>
  buildings - editbuildings: links >
  editbuildings - UpdateBuilding: posts >
  UpdateBuilding - RenderUtil: uses >
}

package "domain layer"  as domain {
}

package "Storage layer" as DB {
  class DBConnection
}

presentation --> domain.DomainFacade  : uses

presentation --> domain.Building : depends on
domain --> DB.DBFacade :uses
DB.DBFacade --> domain.Building : depends on

}
