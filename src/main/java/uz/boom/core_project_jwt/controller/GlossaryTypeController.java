package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.glossary.GlossaryTypeCreateDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryTypeDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.GlossaryTypeServiceImpl;

import java.util.List;

/**
 * @author Jarvis on Tue 21:07. 18/04/23
 */

//@CrossOrigin(origins = "https://main.d1bvq2ei1fv6tu.amplifyapp.com")

@RestController
public class GlossaryTypeController extends AbstractController<GlossaryTypeServiceImpl> {
    public GlossaryTypeController(GlossaryTypeServiceImpl service) {
        super(service);
    }

    @PostMapping(value = PATH + "/glossary-type/create")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> create(@RequestBody GlossaryTypeCreateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.create(dto)));
    }

    @GetMapping(value = PATH + "/glossary-type/getAll")
    public ResponseEntity<DataDTO<List<GlossaryTypeDTO>>> getAll() {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAll()));
    }

    @GetMapping(value = PATH + "/glossary-type/get/{id}")
    public ResponseEntity<DataDTO<GlossaryTypeDTO>> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.get(id)));
    }


    @PutMapping(value = PATH + "/glossary-type/update")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> update(@RequestBody GlossaryTypeDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.update(dto)));
    }

    @DeleteMapping(value = PATH + "/glossary-type/delete/{id}")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.delete(id)));
    }


}
