package app.web.pavelk.database7.controller;

import app.web.pavelk.database7.service.ScheduledService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduledController {

    private final ScheduledService scheduledService;

    @GetMapping("/c")
    public String getBookNameByIsbn() {
        return scheduledService.create();
    }

    @GetMapping("/d")
    public String getBookNameByIsbn2() {
        return scheduledService.delete();
    }


}
