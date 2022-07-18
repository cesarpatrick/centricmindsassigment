package co.nz.centricminds.assignment.service;

import co.nz.centricminds.assignment.model.Contact;
import co.nz.centricminds.assignment.model.Organisation;
import co.nz.centricminds.assignment.repository.OrganisationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganisationService {

    OrganisationRepository organisationRepository;

    public OrganisationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Transactional
    public Organisation save(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    @Transactional
    public List<Organisation> list() {
        return organisationRepository.findAll();
    }

    @Transactional
    public Organisation getOneById(Long id) {
        return organisationRepository.findById(id) .orElse(new Organisation());
    }

    @Transactional
    public List<Organisation> getOneByName(String name) {
        return organisationRepository.getOrganisationByName(name);
    }

}
