package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.DepartmentDTO;
import Gardenia.Model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<DepartmentDTO> findDepartmentBy();

    Optional<DepartmentDTO> findByIdDepartment(Integer id);
}
