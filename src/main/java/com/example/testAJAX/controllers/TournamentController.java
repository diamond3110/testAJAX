package com.example.testAJAX.controllers;

import com.example.testAJAX.models.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class TournamentController {
    University university = new University();
    public static Logger log = LoggerFactory.getLogger(TournamentController.class);
    @GetMapping("/tournamentTable")
    public String getTournamentTable(Model model) {
        log.info("\n" + university.getTableAsString());
        model.addAttribute("tournamentTable", university.getTournamentTable());
        return "table";
    }

}
