package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Gardenia.DTO.AddressDTO;
import Gardenia.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    <T> T findAddressByIdAddress(Class<T> Type, Integer idAddres);// METODO GENERICO PARA BUSQUEDA POR ID ADDRESS puede
                                                                  // retornar el tipo que sea

    List<AddressDTO> findAddressBy();

    Optional<AddressDTO> findAddressByIdAddress(Integer id_address);

}
