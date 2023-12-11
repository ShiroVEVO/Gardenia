package Gardenia.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.RequestDTO;
import Gardenia.Model.Client;
import Gardenia.Model.Request;
import Gardenia.Repository.ClientRepository;
import Gardenia.Repository.RequestRepository;
import Gardenia.Util.ClientKey;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final ClientRepository clientRepository;

    public List<RequestDTO> getAllDTO() {
        return requestRepository.findRequestBy();
    }

    public Optional<RequestDTO> getDTOById(Integer id) {
        return requestRepository.findRequestByIdRequest(id);
    }

    public Optional<Request> getById(Integer id) {
        return requestRepository.findById(id);
    }

    public List<RequestDTO> getByClient(ClientKey clientKey) {
        return requestRepository.findRequestByClient(clientKey.getDocumentType(), clientKey.getDocumentNumber());
    }

    public List<RequestDTO> getByState(String state) {
        return requestRepository.findRequestByState(state);
    }

    public List<RequestDTO> getByDate(Date initialDate, Date finalDate) {
        return requestRepository.findRequeestByDate(initialDate, finalDate);
    }

    public Boolean save(Request request) {
        Optional<Client> optionalClientExisting = clientRepository
                .findClientByClientKey_DocumentTypeAndClientKey_DocumentNumber(
                        request.getClient().getClientKey().getDocumentType(),
                        request.getClient().getClientKey().getDocumentNumber());
        if (optionalClientExisting.isPresent()) {
            //
            // STRANGE PROBLEM, dates are being registered with one day left
            //
            System.out.println("date" + request.getRequestDate());
            requestRepository.save(request);
            return true;
        } else {
            return false;
        }

    }

    public void deleteById(Integer id) {
        requestRepository.deleteById(id);
    }

    public Boolean updateById(Request request, Integer id) {
        System.out.println("date PUT: " + request.getRequestDate());
        Optional<Request> optionalRequestExisting = getById(id);
        if (optionalRequestExisting.isPresent()) {
            Request requestExisting = optionalRequestExisting.get();
            requestExisting.setRequestDate(request.getRequestDate());
            requestExisting.setState(request.getState());
            requestExisting.setTotalAmount(request.getTotalAmount());
            save(requestExisting);
            return true;
        } else {
            return false;
        }
    }
}
