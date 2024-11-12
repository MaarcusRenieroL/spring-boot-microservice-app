package com.maarcus.stock_service.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maarcus.stock_service.model.Stock;
import com.maarcus.stock_service.repository.StockRepository;
import com.maarcus.stock_service.service.StockService;

@Service
public class StockServiceImplementation implements StockService {

  @Autowired private StockRepository stockRepository;

  public Stock createStock(Stock stock) {
    return stockRepository.save(stock);
  }

  public List<Stock> getAllStocks() {
    return stockRepository.findAll();
  }

  public Stock updateStock(int stockId, Stock updatedStock) {
    Optional<Stock> optionalStock = stockRepository.findById(stockId);

    if (optionalStock.isPresent()) {
      Stock existingStock = optionalStock.get();

      existingStock.setName(updatedStock.getName());
      existingStock.setPrice(updatedStock.getPrice());

      return stockRepository.save(existingStock);
    }

    return null;
  }
  public Stock deleteStock(int stockId) {
    Optional<Stock> optionalStock = stockRepository.findById(stockId);
    stockRepository.deleteById(stockId);

    return optionalStock.get();
  }
  
}
