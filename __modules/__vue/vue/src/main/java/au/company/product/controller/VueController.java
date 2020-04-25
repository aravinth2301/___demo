package au.company.product.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class VueController extends ResourceHandlerRegistry {
    private static final String vuePath = "../static/vue/index.html";
    private static final String ngPathPrefix = "../static/angular";

    public VueController(ApplicationContext applicationContext, ServletContext servletContext) {
        super(applicationContext, servletContext);
    }

    @RequestMapping("/vapp/**")
    public String vueIndex(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return vuePath;
    }
    @RequestMapping("/ng/boot/**")
    public String bootIndex(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "redirect:/ng/index.html";
    }
}
