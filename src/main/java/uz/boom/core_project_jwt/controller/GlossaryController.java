package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.glossary.GlossaryCreateDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.GlossaryServiceImpl;

import java.util.List;

/**
 * @author Jarvis on Tue 04:21. 18/04/23
 */

//@CrossOrigin(origins = "https://main.d1bvq2ei1fv6tu.amplifyapp.com")

@RestController
public class GlossaryController extends AbstractController<GlossaryServiceImpl> {
    public GlossaryController(GlossaryServiceImpl service) {
        super(service);
    }


    @PostMapping(value = PATH + "/glossary/create")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> create(@RequestBody GlossaryCreateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.create(dto)));
    }

    @GetMapping(value = PATH + "/glossary/getAll/{glossaryTypeId}")
    public ResponseEntity<DataDTO<List<GlossaryDTO>>> getAllById(@PathVariable(name = "glossaryTypeId") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAllById(id)));
    }

    @GetMapping(value = PATH + "/glossary/getAll")
    public ResponseEntity<DataDTO<List<GlossaryDTO>>> getAll() {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAll()));
    }


    @GetMapping(value = PATH + "/glossary/get/{id}")
    public ResponseEntity<DataDTO<GlossaryDTO>> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.get(id)));
    }


    @PutMapping(value = PATH + "/glossary/update")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> update(@RequestBody GlossaryDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.update(dto)));
    }

    @DeleteMapping(value = PATH + "/glossary/delete/{id}")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.delete(id)));
    }


}
