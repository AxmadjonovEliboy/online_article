package uz.boom.core_project_jwt.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.question.QuestionDTO;
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
@RestController
public class QuizController extends AbstractController<QuizServiceImpl> {

    public QuizController(QuizServiceImpl service) {
        super(service);
    }

    @Operation(
            description = "bu method foydalanuvchi testni bosganda ishlaydi. Bu methodga zapros kelganda u tekshiradi uni tugallanmagan testi bor yuqligini agar tugallanmagan testi yuq bo`lsa yangi test yaratib beradi. Agar tugallanmagan testi bo`lsa o`shani davom etkazish uchun jo`natadi Uni belgilagan javoblarini saqlagan holda jo`natadi"
    )
    @PostMapping(value = PATH + "/quiz")
    public ResponseEntity<DataDTO<QuizDTO>> create(@RequestBody QuizCreateDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.create(dto)));
    }

    @Operation(
            description = "Bu method savol_id, quiz_id va jvobni_id si kelsa tekshirib javobni belgilab, huddi  mashu savolni belgilagan javobi bilan qaytarib jo`natadi"
    )
    @PostMapping(value = PATH + "/check-answer")
    public ResponseEntity<DataDTO<QuestionDTO>> checkAnswer(@RequestBody CheckAnswerDTO dto) {
        return ResponseEntity.ok(
                new DataDTO<>(service.checkAnswer(dto)));
    }


    @Operation(
            description = "Bu method tugatish tugmasini bosganda ishlaydi, bunga quizni_id si kirib keladi va o`sha quizni resultini qaytarib beradi"
    )
    @GetMapping(value = PATH + "/end-quiz/{quizId}")
    public ResponseEntity<DataDTO<ResultDTO>> result(@PathVariable(name = "quizId") Long quizId) {
        return ResponseEntity.ok(
                new DataDTO<>(service.result(quizId)));
    }


    @Operation(
            description = "Bu method resultlarning listini qaytaradi barcha ishlagan testlarining natijalari turadi"
    )
    @GetMapping(value = PATH + "/result-list")
    public ResponseEntity<DataDTO<List<ResultDTO>>> resultArchiveList() {
        return ResponseEntity.ok(
                new DataDTO<>(service.resultArchiveList()));
    }

    @Operation(
            description = "Bu method quizId berilsa o`sha ishlagan quizini to`liq savollarini va u savolni to`g`ri yoki xato ishlaganini ko`rsatadi gan massiv qaytaradi"
    )
    @GetMapping(value = PATH + "/result/{quizId}")
    public ResponseEntity<DataDTO<List<QuestionTitleAnswerDTO>>> resultArchive(@PathVariable(name = "quizId") Long quizId) {
        return ResponseEntity.ok(
                new DataDTO<>(service.resultArchive(quizId)));
    }


}
