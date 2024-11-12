package com.maarcus.portfolio_service.service.implementation;

import com.maarcus.portfolio_service.model.Portfolio;
import com.maarcus.portfolio_service.repository.PortfolioRepository;
import com.maarcus.portfolio_service.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioServiceImplementation implements PortfolioService {
	
	@Autowired private PortfolioRepository portfolioRepository;
	
	public Portfolio createPortfolio(Portfolio portfolio) {
		return portfolioRepository.save(portfolio);
	}
	
	public List<Portfolio> getAllPortfolios() {
		return portfolioRepository.findAll();
	}
	
	public Optional<Portfolio> getPortfolioById(int id) {
		return portfolioRepository.findById(id);
	}
	
	public Portfolio updatePortfolio(int id, Portfolio updatedPortfolio) {
		return portfolioRepository.findById(id)
			.map(portfolio -> {
				portfolio.setName(updatedPortfolio.getName());
				portfolio.setStocks(updatedPortfolio.getStocks());
				portfolio.setTotalValue(updatedPortfolio.getTotalValue());
				return portfolioRepository.save(portfolio);
			}).orElseThrow(() -> new RuntimeException("Portfolio not found"));
	}
	
	public Portfolio deletePortfolio(int id) {
		Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(id);
		
		if (optionalPortfolio.isPresent()) {
			portfolioRepository.deleteById(id);
			return optionalPortfolio.get();
		}
		
		return null;
	}
}
