package tn.esprit.spring;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.IStockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTest {
	@Autowired
	IStockService stockService; 
	
	@Test
	public void testSaveStock(){
		
		Stock s= stockService.saveStock(Stock.builder().libelleStock("Test").qte(100).qteMin(10).build());
		assertNotNull(s);
		
		

	}

}
