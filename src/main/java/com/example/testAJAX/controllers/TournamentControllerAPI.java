package com.example.testAJAX.controllers;

import com.example.testAJAX.models.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TournamentControllerAPI {
    University university = new University();
    public static Logger log = LoggerFactory.getLogger(TournamentControllerAPI.class);
    @CrossOrigin(origins = "http://localhost:1841") // Указываем разрешенный домен
    @GetMapping("/api/tournamentTable")
    public Map<String, Map<String,String>> getTournamentTable() {
        log.info("\n" + university.getTableAsString());
        return university.getTournamentTable();
    }
}
