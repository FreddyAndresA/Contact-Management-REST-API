package ContactManagement.repository;

import ContactManagement.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findByEmail(String email);

    boolean existsByEmailAndIdNot(
            String email,
            Long id
    );

}
