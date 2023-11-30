package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Service;

import Gardenia.Model.Department;
import Gardenia.Repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getById(Integer id) {
        return departmentRepository.findById(id);
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }

    public Department update(Department department, Integer id) {
        Optional<Department> optionalDepartmentExisting = getById(id);
        if (optionalDepartmentExisting.isPresent()) {
            Department departmentExisting = optionalDepartmentExisting.get();
            departmentExisting.setName(department.getName());
            save(departmentExisting);
            return departmentExisting;
        } else {
            // IDK xdd
            return null;
        }

    }
}
