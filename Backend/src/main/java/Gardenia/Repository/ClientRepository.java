package Gardenia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.AddressDTO;
import Gardenia.DTO.ClientDTO;
import Gardenia.Model.Client;
import Gardenia.Util.ClientKey;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, ClientKey> {

        public List<ClientDTO> findClientBy();

        public Optional<Client> findClientByClientKey_DocumentTypeAndClientKey_DocumentNumber(String documentType,
                        Integer DocumentNumber);

        public void deleteClientByClientKey_DocumentTypeAndClientKey_DocumentNumber(String documentType,
                        Integer DocumentNumber);

        @Query(value = "SELECT new Gardenia.DTO.AddressDTO(a.addressValue, a.addressReferences) FROM Address a WHERE a.client.clientKey.documentType = :documentType AND a.client.clientKey.documentNumber = :documentNumber")
        public List<AddressDTO> findAddressesByClient(@Param("documentType") String documentType,
                        @Param("documentNumber") Integer documentInteger);

}
