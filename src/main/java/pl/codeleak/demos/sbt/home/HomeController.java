package pl.codeleak.demos.sbt.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }

    @GetMapping("properties")
    @ResponseBody
    java.util.Properties properties() {
        return System.getProperties();
    }

}
