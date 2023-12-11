package Gardenia.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.RequestDTO;
import Gardenia.Model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    public List<RequestDTO> findRequestBy();

    public Optional<RequestDTO> findRequestByIdRequest(Integer id);

    public List<RequestDTO> findRequestByState(String state);

    @Query("SELECT new Gardenia.DTO.RequestDTO(r.state, r.requestDate, r.totalAmount) FROM Request r WHERE r.client.clientKey.documentType = :documentType AND r.client.clientKey.documentNumber = :documentNumber")
    public List<RequestDTO> findRequestByClient(@Param("documentType") String documentType,
            @Param("documentNumber") Integer documentInteger);

    @Query("SELECT new Gardenia.DTO.RequestDTO(r.state, r.requestDate, r.totalAmount) FROM Request r WHERE r.requestDate BETWEEN :initialDate AND :finalDate")
    public List<RequestDTO> findRequeestByDate(@Param("initialDate") Date initialDate,
            @Param("finalDate") Date finalDate);
}
