package com.maarcus.stock_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maarcus.stock_service.model.Stock;
import com.maarcus.stock_service.service.implementation.StockServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockServiceImplementation stockService;

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock createdStock = stockService.createStock(stock);
        return ResponseEntity.ok(createdStock);
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    @PutMapping("/{stockId}")
    public ResponseEntity<Stock> updateStock(@PathVariable int stockId, @RequestBody Stock updatedStock) {
        Stock stock = stockService.updateStock(stockId, updatedStock);
        return ResponseEntity.ok(stock);
    }

    @DeleteMapping("/{stockId}")
    public ResponseEntity<Stock> deleteStock(@PathVariable int stockId) {
        Stock deletedStock = stockService.deleteStock(stockId);
        return ResponseEntity.ok(deletedStock);
    }
}
