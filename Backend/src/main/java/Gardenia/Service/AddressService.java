package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.AddressDTO;
import Gardenia.Model.Address;
import Gardenia.Model.City;
import Gardenia.Model.Client;
import Gardenia.Repository.AddressRepository;
import Gardenia.Repository.CityRepository;
import Gardenia.Repository.ClientRepository;
import Gardenia.Util.ClientKey;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final ClientRepository clientRepository;

    public List<AddressDTO> getAllDTO() {
        return addressRepository.findAddressBy();
    }

    public Optional<AddressDTO> getDTOById(Integer id) {
        return addressRepository.findAddressByIdAddress(id);
    }

    public Optional<Address> getById(Integer id) {
        return addressRepository.findById(id);
    }

    public List<AddressDTO> getByClient(ClientKey clientKey) {
        Optional<Client> optionalClient = clientRepository
                .findClientByClientKey_DocumentTypeAndClientKey_DocumentNumber(
                        clientKey.getDocumentType(), clientKey.getDocumentNumber());
        if (optionalClient.isPresent()) {
            return clientRepository.findAddressesByClient(clientKey.getDocumentType(), clientKey.getDocumentNumber());
        } else {
            return null;
        }

    }

    public Boolean save(Address address) {
        City addressCity = address.getCity();
        Optional<City> optionalCityExisting = cityRepository.findById(addressCity.getIdCity());
        if (optionalCityExisting.isPresent()) {
            addressRepository.save(address);
            return true;
        } else {
            return false;
        }
    }

    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    public Boolean update(Address address, Integer id) {
        Optional<Address> optionalAddressExisting = getById(id);
        if (optionalAddressExisting.isPresent()) {
            Address addressExisting = optionalAddressExisting.get();
            addressExisting.setAddressValue(address.getAddressValue());
            addressExisting.setAddressReferences(address.getAddressReferences());
            save(addressExisting);
            return true;
        } else {
            return false;
        }
    }

}
