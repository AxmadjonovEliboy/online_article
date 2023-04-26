package uz.boom.core_project_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.question.QuestionTitleAnswerDTO;
import uz.boom.core_project_jwt.dto.quiz.CheckAnswerDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizCreateDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizDTO;
import uz.boom.core_project_jwt.dto.quiz.ResultDTO;
import uz.boom.core_project_jwt.response.DataDTO;
import uz.boom.core_project_jwt.service.QuizServiceImpl;

import java.util.List;

/**
 * @author Jarvis on Sun 01:12. 16/04/23
 */

//@CrossOrigin(origins = "http://16.16.110.106", allowCredentials = "true")

@RestController
public class QuizController extends AbstractController<QuizServiceImpl> {

    public QuizController(QuizServiceImpl service) {
        super(service);
    }

    @PostMapping(value = PATH + "/quiz")
    public ResponseEntity<DataDTO<QuizDTO>> create(@RequestBody QuizCreateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.create(dto)));
    }

    @GetMapping(value = PATH + "/result/{quizId}")
    public ResponseEntity<DataDTO<List<QuestionTitleAnswerDTO>>> resultArchive(@PathVariable(name = "quizId") Long quizId) {
        return ResponseEntity.ok(
                new DataDTO<>(service.resultArchive(quizId)));
    }

    @GetMapping(value = PATH + "/check-answers/{quizId}")
    public ResponseEntity<DataDTO<ResultDTO>> result(@PathVariable(name = "quizId") Long quizId) {
        return ResponseEntity.ok(
                new DataDTO<>(service.result(quizId)));
    }

    @GetMapping(value = PATH + "/result-list")
    public ResponseEntity<DataDTO<List<ResultDTO>>> resultArchiveList() {
        return ResponseEntity.ok(
                new DataDTO<>(service.resultArchiveList()));
    }


    @PostMapping(value = PATH + "/check-answer")
    public ResponseEntity<DataDTO<QuizDTO>> checkAnswer(@RequestBody CheckAnswerDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.checkAnswer(dto)));
    }


}
