package ContactManagement.controller;

import ContactManagement.dto.ContactRequestDTO;
import ContactManagement.dto.ContactResponseDTO;
import ContactManagement.entity.Contact;
import ContactManagement.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @GetMapping
    public List<ContactResponseDTO> getAllContacts() {
        return contactService.getAllContacts();
    }


    @GetMapping("/{id}")
    public ContactResponseDTO getContactById(@PathVariable Long id){
        return contactService.getContactById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponseDTO createContact(@Valid @RequestBody ContactRequestDTO dto) {
        return contactService.createContact(dto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContactById(@PathVariable Long id){
        contactService.deleteContact(id);
    }


    @PutMapping("/{id}")
    public  ContactResponseDTO updateContact(@Valid @PathVariable Long id, @RequestBody ContactRequestDTO dto) {
        return contactService.updateContact(id, dto);
    }

}
