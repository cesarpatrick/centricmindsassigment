package co.nz.centricminds.assignment.controller;

import co.nz.centricminds.assignment.model.Organisation;
import co.nz.centricminds.assignment.service.OrganisationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/organisation")
public class OrganisationController {

    OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService){
        this.organisationService = organisationService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Organisation save(@RequestBody Organisation organisation) {
        return organisationService.save(organisation);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Organisation> list() {
        return organisationService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Organisation getContactById(@PathVariable Long id) {
        return organisationService.getOneById(id);
    }

    @RequestMapping(value = "/filter/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Organisation> getContactByName(@PathVariable String name) {
         return organisationService.getOneByName(name);
    }
}
