package au.company.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class VueController {
    private static final String vuePath = "./vue/index.html";

    @GetMapping("/vapp/**")
    public String vueIndex(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Testing");
        return "index.html";
    }
}
