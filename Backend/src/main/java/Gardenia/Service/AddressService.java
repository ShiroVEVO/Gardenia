package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.AddressDTO;
import Gardenia.Model.Address;
import Gardenia.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public List<AddressDTO> getAllDTO() {
        return addressRepository.findAddressBy();
    }

    public Optional<AddressDTO> getDTOById(Integer id) {
        return addressRepository.findAddressByIdAddress(id);
    }

    public void save(Address address) {
        addressRepository.save(address);
    }

    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    public Address update(Address address, Integer id) {
        Optional<Address> optionalAddressExisting = getById(id);
        if (optionalAddressExisting.isPresent()) {
            Address addressExisting = optionalAddressExisting.get();
            addressExisting.setAddressValue(address.getAddressValue());
            addressExisting.setAddressReferences(address.getAddressReferences());
            save(addressExisting);
            return addressExisting;
        } else {
            // IDK
            return null;
        }
    }

    // Possible
    public Optional<Address> getById(Integer id) {
        return addressRepository.findById(id);
    }

}
