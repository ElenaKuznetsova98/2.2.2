package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {

	@GetMapping(value = "/index")
	public String printWelcome(ModelMap model) {

		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String getListCarByCount(@RequestParam(value = "count") int count, ModelMap modelMap){

		List<Car> carList = new ArrayList<>();
		carList.add(new Car("Ford Focus", "black", 2000));
		carList.add(new Car("Ford", "white", 2005));
		carList.add(new Car("Audi", "blue", 2016));
		carList.add(new Car("BMW", "yellow", 2020));
		carList.add(new Car("Volvo", "grey", 2010));

		List <Car> carListNew = carList.stream().limit(count).collect(Collectors.toList());
		modelMap.addAttribute("carListNew", carListNew);
		return "cars";
	}
}