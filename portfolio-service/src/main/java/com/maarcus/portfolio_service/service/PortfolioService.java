package com.maarcus.portfolio_service.service;

import com.maarcus.portfolio_service.model.Portfolio;

import java.util.List;
import java.util.Optional;

public interface PortfolioService {
	Portfolio createPortfolio(Portfolio portfolio);
	
	List<Portfolio> getAllPortfolios();
	
	Optional<Portfolio> getPortfolioById(int id);
	
	Portfolio updatePortfolio(int id, Portfolio updatedPortfolio);
	
	Portfolio deletePortfolio(int id);
}
