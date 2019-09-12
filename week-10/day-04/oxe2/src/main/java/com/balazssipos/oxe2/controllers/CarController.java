package com.balazssipos.oxe2.controllers;

import com.balazssipos.oxe2.models.entities.Car;
import com.balazssipos.oxe2.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class CarController {
  private CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("/create")
  public String createCars() {
    this.carService.createCars();
    return "redirect:/search";
  }

  @GetMapping("")
  public String renderIndex(@RequestParam(value = "q", required = false) String searchText,
                            @RequestParam(value = "police",
          required = false) Short policeNumber, @RequestParam(value = "diplomat",
          required = false) Short diplomatNumber, Model model) {
    if(searchText != null) {
      List<Car> carList = this.carService.findAllCarsBasedOnSearch(searchText);
      if(carList == null) {
        model.addAttribute("errorMessage", "Sorry, the submitted licence plate is not valid");
        model.addAttribute("cars", this.carService.findAllCars());
      } else {
        model.addAttribute("cars", this.carService.findAllCarsBasedOnSearch(searchText));
      }
    } else if(policeNumber != null) {
      model.addAttribute("cars", this.carService.findAllCarsBasedOnBeginning("RB"));
    } else if(diplomatNumber != null) {
      model.addAttribute("cars", this.carService.findAllCarsBasedOnBeginning("DT"));
    } else {
      model.addAttribute("cars", this.carService.findAllCars());
    }
    return "index";
  }

  @GetMapping("/{brand}")
  public String filterToBrand(@PathVariable("brand") String brand, Model model) {
    model.addAttribute("cars", this.carService.findAllCarsBasedOnSearchFull(brand));
    return "index";
  }
}
