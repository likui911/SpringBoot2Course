package com.example.api;

import com.example.model.Issue;
import com.example.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/issue")
public class IssueController {
    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public int addIssue(@RequestBody Issue issue) {
        System.out.println(issue);
        return 0;
    }

    @GetMapping(path = "{id}")
    public Issue getIssue(@PathVariable int id) {
        return issueService.getIssue(id);
    }

    @PutMapping(path = "{id}")
    public int updateIssue(@PathVariable int id, Issue issue) {
        return issueService.updateIssue(id, issue);
    }

    @DeleteMapping(path = "{id}")
    public int deleteIssue(@PathVariable int id) {
        return issueService.deleteIssue(id);
    }


    @GetMapping(params = "searchTerm")
    public List<Issue> searchIssue(@RequestParam String searchTerm) {
        return issueService.searchIssue(searchTerm);
    }

}
