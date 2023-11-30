package Gardenia.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gardenia.Model.Department;
import Gardenia.Service.DepartmentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentService.getAll();
    }

    @GetMapping("/{id_deparment}")
    public Optional<Department> getDepartmentById(Integer id) {
        return departmentService.getById(id);
    }

    @PostMapping("/save")
    public void saveDepartment() {
        departmentService.save(null);
    }

    @DeleteMapping("/{id_deparment}")
    public void deleteDepartment(@PathVariable("id_deparment") Integer id) {
        departmentService.delete(id);
    }

    @PutMapping("/{id_deparment}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id_deparment") Integer id) {
        departmentService.update(department, id);
        return null;
    }
}
