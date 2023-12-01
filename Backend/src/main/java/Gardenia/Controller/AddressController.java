package Gardenia.Controller;

import java.util.List;
import java.util.Optional;

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
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<AddressDTO> getAddressDTO() {
        return addressService.getAllDTO();
    }

    @GetMapping("/{id_address}")
    public Optional<AddressDTO> getAddressDTOById(@PathVariable("id_address") Integer id) {
        return addressService.getDTOById(id);
    }

    @PostMapping("/save")
    public void saveAddress(@RequestBody Address address) {
        addressService.save(address);
    }

    @DeleteMapping("/{id_address}")
    public void deleteAddressById(@PathVariable("id_address") Integer id) {
        addressService.delete(id);
    }

    @PutMapping("/{id_address}")
    public Address updateAddress(@RequestBody Address address, @PathVariable("id_address") Integer id) {
        return addressService.update(address, id);
    }
}
