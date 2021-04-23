package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
@RequestMapping(value = "/")
public class VizitkaController {
  private final List<Vizitka> vizitky;
  public VizitkaController() {
    vizitky = List.of(
            new Vizitka("Naďa Schopná", "Ajeto a.s.", "Pražská 810/16", "10200, Praha 15", "nada@ajeto.cz", "+420 123456789", "www.ajeto.cz"),
            new Vizitka("Karel Nedělal", "Nedělal a syn", "Horní Lhota 173", "76323, Horní Lhota",null, "+420 777666444", null),
            new Vizitka("Alžběta Nová", "Prodámto s.r.o.", "U Kaple 26", "74766, Dolní Lhota", "anova@prodamto.cz", "+420 723456099", null),
            new Vizitka("Josef Hotový", "Ráj kutilů s.r.o.", "Chraštice 50", "26272, Chraštice", "info@kutilovo.eu", "+420 777039773", "www.kutilovo.eu")
    );
  }

  /**
   * Vrací seznam vizitek
   *
   * Metoda kontroleru obsluhující adresu {@code /}. Používá šablonu {@code /templates/seznam.html}.
   */
  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("seznam", vizitky);
    return modelAndView;
  }

  /**
   * Vrací detail vizitky s mapou
   *
   * Metoda kontroleru obsluhující adresu {@code /detail/}. Používá šablonu {@code /templates/detail.html}.
   */
  @GetMapping("/detail")
  public ModelAndView detail(int id) {
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("vizitka", vizitky.get(id));
    return modelAndView;
  }
}
