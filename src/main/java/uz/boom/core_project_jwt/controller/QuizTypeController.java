package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.quiz.QuizTypeCreateDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizTypeDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.QuizTypeServiceImpl;

import java.util.List;

/**
 * @author Jarvis on Tue 23:52. 18/04/23
 */

//@CrossOrigin(origins = "https://main.d1bvq2ei1fv6tu.amplifyapp.com")

@RestController
public class QuizTypeController extends AbstractController<QuizTypeServiceImpl> {
    public QuizTypeController(QuizTypeServiceImpl service) {
        super(service);
    }

    @PostMapping(value = PATH + "/quiz-type/create")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> create(@RequestBody QuizTypeCreateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.create(dto)));
    }

    @GetMapping(value = PATH + "/quiz-type/getAll")
    public ResponseEntity<DataDTO<List<QuizTypeDTO>>> getAll() {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAll()));
    }

    @GetMapping(value = PATH + "/quiz-type/get/{id}")
    public ResponseEntity<DataDTO<QuizTypeDTO>> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.get(id)));
    }


    @PutMapping(value = PATH + "/quiz-type/update")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> update(@RequestBody QuizTypeDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.update(dto)));
    }

    @DeleteMapping(value = PATH + "/quiz-type/delete/{id}")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.delete(id)));
    }

}
