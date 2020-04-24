package au.company.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class VueController {
    private static final String vuePath = "../static/vue/index.html";

    @RequestMapping("/vapp/**")
    public String vueIndex(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return vuePath;
    }
}
