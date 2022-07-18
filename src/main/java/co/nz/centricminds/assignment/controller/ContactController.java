package co.nz.centricminds.assignment.controller;

import co.nz.centricminds.assignment.model.Contact;
import co.nz.centricminds.assignment.service.ContactService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contact")
public class ContactController {

    ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact save(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> list() {
        return contactService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getOneById(id);
    }

    @RequestMapping(value = "/listByOrganisation/{organisationId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getContactsByOrganisationId(@PathVariable Long organisationId) {
        return contactService.getContactsByOrganisationId(organisationId);
    }

    @RequestMapping(value = "/filter/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getContactByName(@PathVariable String name) {
            return contactService.getContactByName(name);
    }
}
