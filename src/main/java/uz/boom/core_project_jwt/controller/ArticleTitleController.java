package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleArticleDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleUpdateDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.ArticleTitleServiceImpl;

import java.util.List;

/**
 * @author Jarvis on Sat 01:12. 15/04/23
 */
//@CrossOrigin(origins = "https://main.d1bvq2ei1fv6tu.amplifyapp.com")

@RestController
public class ArticleTitleController extends AbstractController<ArticleTitleServiceImpl> {
    public ArticleTitleController(ArticleTitleServiceImpl service) {
        super(service);
    }


    @PostMapping(value = PATH + "/article-title/create")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> create(@RequestBody ArticleTitleCreateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.create(dto)));
    }

    @GetMapping(value = PATH + "/article-titles/getAll/{articleTypeId}")
    public ResponseEntity<DataDTO<List<ArticleTitleDTO>>> getAll(@PathVariable(name = "articleTypeId") Long articleTypeId) {
        return ResponseEntity.ok(
                new DataDTO<>(service.getAll(articleTypeId)));
    }

    @GetMapping(value = PATH + "/article-title/get/{id}")
    public ResponseEntity<DataDTO<ArticleTitleArticleDTO>> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.get(id)));
    }


    @PutMapping(value = PATH + "/article-title/update")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> update(@RequestBody ArticleTitleUpdateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.update(dto)));
    }

    @DeleteMapping(value = PATH + "/article-title/delete/{id}")
    @PreAuthorize("hasAuthority('SUPPER_ADMIN') or hasAuthority('ADMIN')")
    public ResponseEntity<DataDTO<Long>> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(
                new DataDTO<>(service.delete(id)));
    }


}
