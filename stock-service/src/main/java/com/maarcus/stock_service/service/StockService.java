package com.maarcus.stock_service.service;

import java.util.List;

import com.maarcus.stock_service.model.Stock;

public interface StockService {
  Stock createStock(Stock stock);

  List<Stock> getAllStocks();

  Stock updateStock(int stockId, Stock updatedStock);

  Stock deleteStock(int stockId);
}
