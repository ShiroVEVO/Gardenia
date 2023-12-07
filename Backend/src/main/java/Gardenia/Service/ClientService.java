package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.ClientDTO;
import Gardenia.Model.Client;
import Gardenia.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientDTO> getAllDTO() {
        return clientRepository.findClientBy();
    }

    public Optional<ClientDTO> getDTOByKey(String DocumentType, Integer DocumentNumber) {
        Optional<Client> client = getByKey(DocumentType, DocumentNumber);
        if (client.isPresent()) {
            Client clientExisting = client.get();
            return Optional.of(new ClientDTO(clientExisting.getNames(), clientExisting.getLastnames(),
                    clientExisting.getPhoneNumber()));
        } else {
            return null;
        }
    }

    public Optional<Client> getByKey(String DocumentType, Integer DocumentNumber) {
        return clientRepository.findClientByClientKey_DocumentTypeAndClientKey_DocumentNumber(
                DocumentType,
                DocumentNumber);
    }

    public Boolean save(Client client) {
        clientRepository.save(client);
        return true;
    }

    @Transactional
    public void deleteById(String DocumentType, Integer DocumentNumber) {
        clientRepository.deleteClientByClientKey_DocumentTypeAndClientKey_DocumentNumber(DocumentType, DocumentNumber);
    }

    public Boolean updateById(Client client) {
        // PENDING
        return false;
    }
}
