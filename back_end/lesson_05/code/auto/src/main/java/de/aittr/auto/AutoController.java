package de.aittr.auto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/autos")
public class AutoController {
    private AutoService service;

    public AutoController(AutoService service) {
        this.service = service;
    }

    @GetMapping
    public String getAutosMapping(Model model){
        model.addAttribute("myListOfAutos", service.getAllAutos());
        return "autos_view";
    }

    @GetMapping("/add")
    public String getAddForm(Model model){
        Auto auto = new Auto();
        model.addAttribute("auto", auto);
        return "add_auto";
    }

    @GetMapping("/{auto_id}") // autos/1    autos/22  autos/34
    public String getAutoByID(@PathVariable(name = "auto_id") Long id, Model model){
        Optional<Auto> optionalAuto = service.getAutoById(id);
        Auto auto = optionalAuto.get();
        model.addAttribute("auto", auto);
        return "auto";
    }

    @PostMapping
    public  String postNewAuto(@ModelAttribute("auto") Auto auto){
        service.saveAuto(auto);
        return "redirect:/autos";
    }

}
