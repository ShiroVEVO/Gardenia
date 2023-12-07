package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.DepartmentDTO;
import Gardenia.Model.City;
import Gardenia.Model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<DepartmentDTO> findDepartmentBy();

    Optional<DepartmentDTO> findDepartmentByIdDepartment(Integer id);

    @Query(value = "SELECT d.cities FROM Department d WHERE d.idDepartment = :departmentId")
    List<City> findCitiesByDepartment(@Param("departmentId") Integer departmentId);
}
