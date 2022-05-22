package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.IStockService;

@RestController
@RequestMapping("stock")
public class StockController {
	@Autowired
	IStockService stockService;
	
	@GetMapping("/show")
	@ResponseBody 
	List<Stock> show(){
	return stockService.retrieveStock();
	}
	
	
	@GetMapping("/show/{id}")
	@ResponseBody 
	Stock showByid(@PathVariable("id")Long idstcok) {
	return stockService.retrieveById(idstcok);
	}
	
	@PostMapping("/add")
	@ResponseBody
	Stock add(@RequestBody Stock s) {
	return stockService.saveStock(s);
	}
	
	@PutMapping("/update")
	@ResponseBody
	Stock update(@RequestBody Stock s) { 
	return stockService.updateStock(s);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	void delete(@PathVariable("id") Long id) {
	stockService.deleteStock(id);
	}


}