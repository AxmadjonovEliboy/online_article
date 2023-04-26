package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.article_title.ArticleUpdateDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.ArticleServiceImpl;

/**
 * @author Jarvis on Sat 01:15. 15/04/23
 */
//@CrossOrigin(origins = "http://16.16.110.106", allowCredentials = "true")
@RestController
public class ArticleController extends AbstractController<ArticleServiceImpl> {
    public ArticleController(ArticleServiceImpl service) {
        super(service);
    }

    @GetMapping(value = PATH + "/articles/getAll")
    public ResponseEntity<DataDTO<Object>> getAll() {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAll()));
    }

    @GetMapping(value = PATH + "/article/get/{id}")
    public ResponseEntity<DataDTO<Object>> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.get(id)));
    }

    @PutMapping(value = PATH + "/article/update")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> update(@RequestBody ArticleUpdateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.update(dto)));
    }

    @DeleteMapping(value = PATH + "/article/delete/{id}")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.delete(id)));
    }

}
