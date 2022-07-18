package co.nz.centricminds.assignment.repository;

import co.nz.centricminds.assignment.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    @Query(value = "select o.id, o.name, o.address, o.url from organisation as o where o.name like %:name% ", nativeQuery = true)
    public List<Organisation> getOrganisationByName(@Param("name") String name);
}
