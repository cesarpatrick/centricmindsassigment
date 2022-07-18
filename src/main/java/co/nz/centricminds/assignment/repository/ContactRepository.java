package co.nz.centricminds.assignment.repository;

import co.nz.centricminds.assignment.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "select c.id, c.name, c.phone, c.email from contact as c " +
            "inner join contact_organisation co on co.contact_id = c.id " +
            "where co.organisations_id = :orgId", nativeQuery = true)
    public List<Contact> getContactsByOrganisationId(@Param("orgId") Long orgId);

    @Query(value = "select c.id, c.name, c.phone, c.email from contact as c where c.name like %:name% ", nativeQuery = true)
    public List<Contact> getContactByName(@Param("name") String name);
}
