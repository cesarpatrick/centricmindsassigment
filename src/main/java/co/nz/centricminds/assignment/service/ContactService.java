package co.nz.centricminds.assignment.service;

import co.nz.centricminds.assignment.model.Contact;
import co.nz.centricminds.assignment.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {

    ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    public List<Contact> list() {
        return contactRepository.findAll();
    }

    @Transactional
    public Contact getOneById(Long id) {
        return contactRepository.findById(id) .orElse(new Contact());
    }

    @Transactional
    public List<Contact> getContactsByOrganisationId(Long id) {
        return contactRepository.getContactsByOrganisationId(id);
    }

    @Transactional
    public List<Contact> getContactByName(String name) {
        return contactRepository.getContactByName(name);
    }
}
