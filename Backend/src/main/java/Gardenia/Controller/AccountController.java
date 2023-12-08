package Gardenia.Controller;

import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.AccountDTO;
import Gardenia.Model.Account;
import Gardenia.Service.AccountService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<AccountDTO> getAllAcounts() {
        return accountService.getAllDTO();
    }

    @GetMapping("/{id_account}")
    public Optional<AccountDTO> getAccountById(@PathVariable("id_account") Integer id) {
        return accountService.getDTOById(id);
    }

    @PostMapping("/save")
    public Boolean saveAccount(@RequestBody Account account) {
        // FALTA SI EXISTE EL CLIENTE
        return accountService.save(account);
    }

    @DeleteMapping("/{id_account}")
    public void deleteAccountById(@PathVariable("id_account") Integer id) {
        accountService.deleteById(id);
    }

    @PutMapping("/{id_account}")
    public Boolean updateAccountById(@RequestBody Account account, @PathVariable("id_account") Integer id) {
        return accountService.updateById(account, id);
    }
}
