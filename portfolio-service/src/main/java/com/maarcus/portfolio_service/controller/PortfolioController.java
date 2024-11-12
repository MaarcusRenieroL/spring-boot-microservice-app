package com.maarcus.portfolio_service.controller;

import com.maarcus.portfolio_service.model.Portfolio;
import com.maarcus.portfolio_service.service.implementation.PortfolioServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {
	
	@Autowired private PortfolioServiceImplementation portfolioService;
	
	@PostMapping
	public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
		Portfolio createdPortfolio = portfolioService.createPortfolio(portfolio);
		return ResponseEntity.ok(createdPortfolio);
	}
	
	@GetMapping
	public ResponseEntity<List<Portfolio>> getAllPortfolios() {
		List<Portfolio> portfolios = portfolioService.getAllPortfolios();
		return ResponseEntity.ok(portfolios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Portfolio> getPortfolioById(@PathVariable int id) {
		return portfolioService.getPortfolioById(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Portfolio> updatePortfolio(@PathVariable int id, @RequestBody Portfolio updatedPortfolio) {
		Portfolio portfolio = portfolioService.updatePortfolio(id, updatedPortfolio);
		return ResponseEntity.ok(portfolio);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Portfolio> deletePortfolio(@PathVariable int id) {
		return ResponseEntity.ok(portfolioService.deletePortfolio(id));
	}
}
