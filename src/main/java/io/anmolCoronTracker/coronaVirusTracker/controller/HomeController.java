package io.anmolCoronTracker.coronaVirusTracker.controller;

import io.anmolCoronTracker.coronaVirusTracker.modals.LocationStats;
import io.anmolCoronTracker.coronaVirusTracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;
    @GetMapping("/")
    public  String home(Model model){
        List<LocationStats> allstats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allstats.stream().mapToInt(stat-> stat.getLatestTotalCases()).sum();
        model.addAttribute("locationstats",allstats);
        model.addAttribute("totalReportedCases",totalReportedCases);
        return "Home.html";
    }
}
