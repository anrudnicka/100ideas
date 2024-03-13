package rudnicka.a.ideas.admin.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rudnicka.a.ideas.question.service.QuestionService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminViewController {
    private final QuestionService questionService;

    @GetMapping
    public String indexView(Model model){
        model.addAttribute("statistics", questionService.statistics());
        return "admin/index";
    }
}
