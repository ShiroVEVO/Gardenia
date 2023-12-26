package Gardenia.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
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
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDTO();
    }

    @GetMapping("/{id_department}")
    public Optional<DepartmentDTO> getDepartmentById(@PathVariable("id_department") Integer id) {
        return departmentService.getDTOById(id);
    }

    @PostMapping("/save")
    public Boolean saveDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("/{id_department}")
    public void deleteDepartmentById(@PathVariable("id_department") Integer id) {
        departmentService.deleteById(id);
    }

    @PutMapping("/{id_department}")
    public Boolean updateDepartmentById(@RequestBody Department department, @PathVariable("id_department") Integer id) {
        return departmentService.updateById(department, id);
    }
}
