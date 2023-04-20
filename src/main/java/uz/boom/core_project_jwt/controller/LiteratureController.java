package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.article_title.LiteratureCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.LiteratureDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.LiteratureServiceImpl;

import java.util.List;

/**
 * @author Jarvis on Tue 03:28. 18/04/23
 */

//@CrossOrigin(origins = "https://main.d1bvq2ei1fv6tu.amplifyapp.com")

@RestController
public class LiteratureController extends AbstractController<LiteratureServiceImpl> {
    public LiteratureController(LiteratureServiceImpl service) {
        super(service);
    }

    @PostMapping(value = PATH + "/literature/create")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> create(@RequestBody LiteratureCreateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.create(dto)));
    }

    @GetMapping(value = PATH + "/literature/getAll/{type}")
    public ResponseEntity<DataDTO<List<LiteratureDTO>>> getAllByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAllByType(type)));
    }

    @GetMapping(value = PATH + "/literature/getAll")
    public ResponseEntity<DataDTO<List<LiteratureDTO>>> getAll() {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAll()));
    }

    @GetMapping(value = PATH + "/literature/get/{id}")
    public ResponseEntity<DataDTO<LiteratureDTO>> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.get(id)));
    }


    @PutMapping(value = PATH + "/literature/update")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> update(@RequestBody LiteratureDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.update(dto)));
    }

    @DeleteMapping(value = PATH + "/literature/delete/{id}")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.delete(id)));
    }

}
