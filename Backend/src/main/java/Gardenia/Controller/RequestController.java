package Gardenia.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gardenia.Service.RequestService;
import Gardenia.Util.ClientKey;
import Gardenia.Util.DateIntervals;
import Gardenia.DTO.RequestDTO;
import Gardenia.Model.Request;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;

    @GetMapping
    public List<RequestDTO> getAllRequest() {
        return requestService.getAllDTO();
    }

    @GetMapping("/{id_request}")
    public Optional<RequestDTO> getRequestsById(@PathVariable("id_request") Integer id) {
        return requestService.getDTOById(id);
    }

    @PostMapping("/client")
    public List<RequestDTO> getRequestsByClient(@RequestBody ClientKey clientKey) {
        return requestService.getByClient(clientKey);
    }

    @GetMapping("/state/{state}")
    public List<RequestDTO> getRequestsByState(@PathVariable("state") String state) {
        return requestService.getByState(state);
    }

    @PostMapping("/date")
    public List<RequestDTO> getRequestsByDate(@RequestBody DateIntervals dateIntervals) {
        return requestService.getByDate(dateIntervals.getInitialDate(), dateIntervals.getFinalDate());
    }

    @PostMapping("/save")
    public Boolean saveRequest(@RequestBody Request request) {
        return requestService.save(request);
    }

    @DeleteMapping("/{id_request}")
    public void deleteRequestById(@PathVariable("id_request") Integer id) {
        requestService.deleteById(id);
    }

    @PutMapping("/{id_request}")
    public Boolean updateRequestById(@PathVariable("id_request") Integer id, @RequestBody Request request) {
        return requestService.updateById(request, id);
    }

}
