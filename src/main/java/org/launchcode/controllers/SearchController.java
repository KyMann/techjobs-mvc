package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value = "results") //this is a post at search from the given get?
    public String results (Model model, String searchType, String searchTerm) {
        //from JobData class - get search results
        ArrayList<HashMap<String, String>>  searched = JobData.findByColumnAndValue(searchType, searchTerm);
        //pass the results into search.html look to existing search handler for help
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("joblist", searched);
        return "search";//what do we return?
    }
}
