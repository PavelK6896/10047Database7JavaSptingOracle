package app.web.pavelk.database7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequiredArgsConstructor
public class OneController {

    @GetMapping("/")
    public String returnNoFavicon() {
        return HtmlUtils.htmlEscape("index.html");
    }

}
