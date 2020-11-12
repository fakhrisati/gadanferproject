package com.survey.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.survey.model.SurveyResult;
import com.survey.repository.SuervyResultRepo;

@Controller
public class MainController {

	@Autowired
	private SuervyResultRepo suervyResultRepo;
    @GetMapping("/")
    public String root(Model model) {
    	SurveyResult surveyResult = new SurveyResult();
    	model.addAttribute("surveyResult", surveyResult);
        return "index";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute SurveyResult surveyResultl) {
    	System.out.println(surveyResultl.getAwnser());
    	suervyResultRepo.save(surveyResultl);
        return "submitmsg";
    }

    @GetMapping("/stat")

    public String stat(Model model) {
    	int noCount = suervyResultRepo.getNoCount();
    	int yesCount = suervyResultRepo.getYesCount();
    	model.addAttribute("noCount", noCount);
    	model.addAttribute("yesCount", yesCount);

        return "stat";
    }
    
    
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
