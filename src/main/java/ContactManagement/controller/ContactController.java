package ContactManagement.controller;

import ContactManagement.dto.ContactRequestDTO;
import ContactManagement.dto.ContactResponseDTO;
import ContactManagement.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Contact Management",
        description = "REST API for managing contacts. Supports creating, retrieving, updating, and deleting contact information."
)
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }



    // GET ALL CONTACTS
    @Operation(
            summary = "Retrieve all contacts",
            description = "Returns a list of all contacts stored in the database."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Contacts retrieved successfully"
            )
    })
    @GetMapping
    public List<ContactResponseDTO> getAllContacts() {
        return contactService.getAllContacts();
    }



    // GET A CONTACT
    @Operation(
            summary = "Retrieve a contact by ID",
            description = "Returns a specific contact using its unique identifier."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Contact found successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Contact not found"
            )
    })
    @GetMapping("/{id}")
    public ContactResponseDTO getContactById(@PathVariable Long id){
        return contactService.getContactById(id);
    }



    // POST CONTACT
    @Operation(
            summary = "Create a new contact",
            description = "Creates a new contact and stores it in the database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Contact created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Email already exists"
            )
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponseDTO createContact(@Valid @RequestBody ContactRequestDTO dto) {
        return contactService.createContact(dto);
    }



    // DELETE CONTACT
    @Operation(
            summary = "Delete a contact by ID",
            description = "Removes a contact from the database using its unique identifier."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Contact deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Contact not found"
            )
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContactById(@PathVariable Long id){
        contactService.deleteContact(id);
    }



    // EDIT CONTACT
    @Operation(
            summary = "Update an existing contact",
            description = "Updates the information of an existing contact identified by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Contact updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Contact not found"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "The email is already assigned to another contact"
            )
    })
    @PutMapping("/{id}")
    public  ContactResponseDTO updateContact(@Valid @PathVariable Long id, @RequestBody ContactRequestDTO dto) {
        return contactService.updateContact(id, dto);
    }

}
