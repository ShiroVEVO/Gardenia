package Gardenia.Controller;

import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.ClientDTO;
import Gardenia.Model.Client;
import Gardenia.Service.ClientService;
import Gardenia.Util.ClientKey;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllDTO();
    }

    @PostMapping("/search")
    public Optional<ClientDTO> getClientByKey(@RequestBody ClientKey clientKey) {
        return clientService.getDTOByKey(clientKey.getDocumentType(), clientKey.getDocumentNumber());
    }

    @PostMapping("/save")
    public Boolean saveClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PostMapping("/delete")
    public void deleteClientByKey(@RequestBody ClientKey clientKey) {
        clientService.deleteById(clientKey.getDocumentType(), clientKey.getDocumentNumber());
    }

    @PutMapping
    public Boolean updateClientByKey(@RequestBody Client client) {
        return clientService.updateById(client);
    }
}
