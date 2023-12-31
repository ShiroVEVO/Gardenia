package Gardenia.Controller;

import java.util.List;
import java.util.Optional;

/*
El body de una petición save para address luce talque:

{
  "addressValue": "123 Main Street",
  "addressReferences": "Near the park",
  "city": {
    "idCity": 1, // El ID de la ciudad a la que pertenece la dirección
    "name": "Example City"
  }
}
*/

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.AddressDTO;
import Gardenia.Model.Address;
import Gardenia.Service.AddressService;
import Gardenia.Util.ClientKey;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<AddressDTO> getAllddresses() {
        return addressService.getAllDTO();
    }

    @GetMapping("/{id_address}")
    public Optional<AddressDTO> getAddressById(@PathVariable("id_address") Integer id) {
        return addressService.getDTOById(id);
    }

    @PostMapping("/client")
    public List<AddressDTO> getAddresByClient(@RequestBody ClientKey clientKey) {
        // FALTA CAMBIARLO A ADDRESS DTO
        return addressService.getByClient(clientKey);
    }

    @PostMapping("/save")
    public Boolean saveAddress(@RequestBody Address address) {
        return addressService.save(address);
    }

    @DeleteMapping("/{id_address}")
    public void deleteAddressById(@PathVariable("id_address") Integer id) {
        addressService.delete(id);
    }

    @PutMapping("/{id_address}")
    public Boolean updateAddress(@RequestBody Address address, @PathVariable("id_address") Integer id) {
        return addressService.update(address, id);
    }
}
