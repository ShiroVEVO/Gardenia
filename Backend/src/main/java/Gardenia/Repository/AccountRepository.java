package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.AccountDTO;
import Gardenia.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    public List<AccountDTO> findAccountBy();

    public Optional<AccountDTO> findAccountByIdAccount(Integer id);

}
