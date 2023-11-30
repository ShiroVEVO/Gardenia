package Gardenia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Gardenia.Model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
