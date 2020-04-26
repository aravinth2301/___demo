package au.company.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class VueController {
    private static final String vuePath = "../static/vue/index.html";
    private static final String ngPathPrefix = "../static/angular";

    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:/vapp";
    }

    @RequestMapping("/vapp/**")
    public String vueIndex(Model model) {
        return vuePath;
    }
    @RequestMapping("/ng/boot/**")
    public String bootIndex(Model model) {
        return "redirect:/ng/index.html";
    }
}
