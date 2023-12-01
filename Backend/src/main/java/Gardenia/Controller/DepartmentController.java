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

import Gardenia.DTO.DepartmentDTO;
import Gardenia.Model.Department;
import Gardenia.Service.DepartmentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDTO> getAllDepartment() {
        return departmentService.getAllDTO();
    }

    @GetMapping("/{id_deparment}")
    public Optional<DepartmentDTO> getDepartmentById(Integer id) {
        return departmentService.getDTOById(id);
    }

    @PostMapping("/save")
    public void saveDepartment(@RequestBody Department department) {
        departmentService.save(department);
    }

    @DeleteMapping("/{id_deparment}")
    public void deleteDepartment(@PathVariable("id_deparment") Integer id) {
        departmentService.delete(id);
    }

    @PutMapping("/{id_deparment}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id_deparment") Integer id) {
        return departmentService.update(department, id);
    }
}
