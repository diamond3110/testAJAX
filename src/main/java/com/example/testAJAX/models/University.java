package com.example.testAJAX.models;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class University {
    public  static Map<String, Map<String, String>> tournamentTable = new HashMap<>();
    public University(){
        Map<String, String> teams = new HashMap<>();
        teams.put("UTM", " 0 ");
        teams.put("USM", " 0 ");
        teams.put("USMF", " 0 ");
        teams.put("USEFS", " 0 ");
        teams.put("ASEM", " 0 ");
        for(String s: teams.keySet()){
            tournamentTable.put(s, teams);
        }
        for(String s: tournamentTable.keySet()){
            Map<String, String> innerMapCopy = new HashMap<>(tournamentTable.get(s));
            innerMapCopy.put(s, " X ");
            tournamentTable.put(s, innerMapCopy);
        }
    }

    public Map<String,Map<String,String>> getTournamentTable(){
        return tournamentTable;
    }
    public void updateTable(String expression){
        String[] str = expression.split("-");
        Map<String, String> innerMapCopy = new HashMap<>(tournamentTable.get(str[1]));
        innerMapCopy.put(str[0], str[2]);
        tournamentTable.put(str[1], innerMapCopy);
    }
    public String getTableAsString() {
        StringBuilder tableString = new StringBuilder();
        String delimiter = "+------------+------------+------------+------------+------------+------------+\n";
        tableString.append(delimiter);
        tableString.append(String.format("|%12s", ""));
        for (String s : tournamentTable.keySet()) {
            tableString.append(String.format("|%3s%-6s%3s", "", s, ""));
        }
        tableString.append("|\n").append(delimiter);
        for (String s : tournamentTable.keySet()) {
            tableString.append(String.format("|%3s%-6s%3s", "", s, ""));
            for (String str : tournamentTable.get(s).values()) {
                tableString.append(String.format("|%3s%-6s%3s", "", str, ""));
            }
            tableString.append("|\n").append(delimiter);
        }
        return tableString.toString();
    }
}