package rudnicka.a.ideas.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rudnicka.a.ideas.category.dto.CategoryWithStatisticsDto;
import rudnicka.a.ideas.question.dto.QuestionDto;
import rudnicka.a.ideas.question.service.QuestionService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexViewController extends IdeasCommonViewController{
    private final QuestionService questionService;


    public String indexView(Model model){
        addGlobalAttributes(model);
        List <QuestionDto> questionTop = questionService.findTop(2);
        model.addAttribute("questionsTop", questionTop);

        List<CategoryWithStatisticsDto> categories = categoryService.findAllWithStatistics();
        model.addAttribute("categories", categories);
        return "index/index";
    }

    public List<QuestionDto>topQuestionsByCategory(UUID categoryId){
        List<QuestionDto> topQuestions = questionService.findTop(categoryId, 2);
        return topQuestions;
    }
    public List<QuestionDto> randomQuestions(){
        List<QuestionDto> randomQuestions = questionService.findRandom(2);
        return randomQuestions;
    }
}
