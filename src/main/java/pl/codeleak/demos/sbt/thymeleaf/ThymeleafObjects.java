package pl.codeleak.demos.sbt.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

// http://blog.codeleak.pl/2014/05/spring-mvc-and-thymeleaf-how-to-acess-data-from-templates.html
@Controller
class ThymeleafObjects {

    @ModelAttribute("messages")
    List<String> messages() {
        return Arrays.asList("Message 1", "Message 2", "Message 3");
    }

    @GetMapping("/model-attr")
    String modelAttributes(Model model) {
        return "th-objects";
    }

    @GetMapping("/query-params")
    String queryParams() {
        return "redirect:/model-attr?q=My Query";
    }

    @GetMapping("/session-attr")
    String sessionAttributes(HttpSession session) {
        session.setAttribute("mySessionAttribute", "Session Attr 1");
        return "th-objects";
    }

    @GetMapping("/flash-attr")
    String flashAttributes(RedirectAttributes ra) {
        ra.addFlashAttribute("flash", "Flash Demo");
        return "redirect:/model-attr";
    }

    @Configuration
    public class MyConfiguration {
        @Bean(name = "urlService")
        public UrlService urlService() {
            return () -> "domain.com/myapp";
        }
    }

    public interface UrlService {
        String getApplicationUrl();
    }

}
