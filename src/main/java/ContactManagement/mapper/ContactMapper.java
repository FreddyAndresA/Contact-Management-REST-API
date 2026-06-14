package ContactManagement.mapper;

import ContactManagement.dto.ContactRequestDTO;
import ContactManagement.dto.ContactResponseDTO;
import ContactManagement.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    // DTO → Entity (to create or update)
    public Contact toEntity(ContactRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Contact contact = new Contact();

        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
        contact.setCellphone(dto.getCellphone());
        contact.setDateOfBirth(dto.getDateOfBirth());

        return contact;
    }


    // Entity → ResponseDTO (to provide the response)
    public ContactResponseDTO toResponseDTO(Contact contact) {
        if (contact == null) {
            return null;
        }

        ContactResponseDTO dto = new ContactResponseDTO();

        dto.setId(contact.getId());
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setEmail(contact.getEmail());
        dto.setPhone(contact.getPhone());
        dto.setCellphone(contact.getCellphone());
        dto.setDateOfBirth(contact.getDateOfBirth());

        return dto;
    }

}
