package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.AccountDTO;
import Gardenia.Model.Account;
import Gardenia.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<AccountDTO> getAllDTO() {
        return accountRepository.findAccountBy();
    }

    public Optional<AccountDTO> getDTOById(Integer id) {
        return accountRepository.findAccountByIdAccount(id);
    }

    public Optional<Account> getById(Integer id) {
        return accountRepository.findById(id);
    }

    public Boolean save(Account account) {
        accountRepository.save(account);
        return true;
    }

    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }

    public Boolean updateById(Account account, Integer id) {
        Optional<Account> optionalAccountExisting = getById(id);
        if (optionalAccountExisting.isPresent()) {
            Account accountExisting = optionalAccountExisting.get();
            accountExisting.setEmail(account.getEmail());
            accountExisting.setPassword(account.getPassword());
            accountExisting.setBirthDate(account.getBirthDate());
            accountExisting.setRole(account.getRole());
            save(accountExisting);
            return true;
        } else {
            return false;
        }
    }
}
