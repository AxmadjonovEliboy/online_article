package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.question.QuestionCreateDTO;
import uz.boom.core_project_jwt.dto.question.QuestionDTO;
import uz.boom.core_project_jwt.dto.question.QuestionUpdateDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.QuestionServiceImpl;

import java.util.List;

/**
 * @author Jarvis on Sat 17:03. 15/04/23
 */

//@CrossOrigin(origins = "http://16.16.110.106", allowCredentials = "true")

@RestController
public class QuestionController extends AbstractController<QuestionServiceImpl> {

    public QuestionController(QuestionServiceImpl service) {
        super(service);
    }

    @PostMapping(value = PATH + "/question/create")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> create(@RequestBody QuestionCreateDTO dto) {
        return ResponseEntity.ok(new DataDTO<>(service.create(dto)));
    }


    @GetMapping(value = PATH + "/question/get/{id}")
    public ResponseEntity<DataDTO<QuestionDTO>> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new DataDTO<>(service.get(id)));
    }

    @GetMapping(value = PATH + "/question/getAll")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<List<QuestionDTO>>> getAll() {
        return ResponseEntity.ok(new DataDTO<>(service.getAll()));
    }

    @GetMapping(value = PATH + "/question/getAll/{questionTypeId}")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<List<QuestionDTO>>> getAllByType(@PathVariable(name = "questionTypeId") Long id) {
        return ResponseEntity.ok(new DataDTO<>(service.getAllByType(id)));
    }

    @PutMapping(value = PATH + "/question/update")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> update(@RequestBody QuestionUpdateDTO dto) {
        return ResponseEntity.ok(new DataDTO<>(service.update(dto)));
    }

    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    @DeleteMapping(value = PATH + "/question/delete/{id}")
    public ResponseEntity<DataDTO<Long>> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new DataDTO<>(service.delete(id)));
    }


}
