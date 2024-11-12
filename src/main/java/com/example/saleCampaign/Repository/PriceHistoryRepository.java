package com.example.saleCampaign.Repository;

import com.example.saleCampaign.Model.PriceHistory;
import com.example.saleCampaign.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {
    Optional<PriceHistory> findPriceHistoryByLocalDate(LocalDate localDate);

    @Query(value = "SELECT * FROM price_history WHERE product_id = :productId AND date = :date ORDER BY id DESC LIMIT 1", nativeQuery = true)
    PriceHistory findTopByProductIdAndDate(@Param("productId") int productId, @Param("date") LocalDate date);

}
