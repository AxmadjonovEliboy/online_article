package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.ArticleTypeServiceImpl;

import java.util.List;

/**
 * @author Jarvis on Mon 16:43. 17/04/23
 */

//@CrossOrigin(origins = "http://16.16.110.106", allowCredentials = "true")

@RestController
public class ArticleTypeController extends AbstractController<ArticleTypeServiceImpl> {
    public ArticleTypeController(ArticleTypeServiceImpl service) {
        super(service);
    }


    @PostMapping(value = PATH + "/article-type/create")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> create(@RequestBody ArticleTypeCreateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.create(dto)));
    }

    @GetMapping(value = PATH + "/article-type/getAll")
    public ResponseEntity<DataDTO<List<ArticleTypeDTO>>> getAll() {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAll()));
    }

    @GetMapping(value = PATH + "/article-type/get/{id}")
    public ResponseEntity<DataDTO<ArticleTypeDTO>> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.get(id)));
    }


    @PutMapping(value = PATH + "/article-type/update")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> update(@RequestBody ArticleTypeDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.update(dto)));
    }

    @DeleteMapping(value = PATH + "/article-type/delete/{id}")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.delete(id)));
    }


}
