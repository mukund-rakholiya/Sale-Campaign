package com.example.saleCampaign.scheduler;

import com.example.saleCampaign.Model.Campaign;
import com.example.saleCampaign.Model.CampaignDiscount;
import com.example.saleCampaign.Model.PriceHistory;
import com.example.saleCampaign.Model.Product;
import com.example.saleCampaign.Repository.CampaignRepository;
import com.example.saleCampaign.Repository.PriceHistoryRepository;
import com.example.saleCampaign.Repository.ProductRepository;
import com.example.saleCampaign.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class PriceAdjustmentScheduler {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ProductService productService;


    @Autowired
    PriceHistoryRepository priceHistoryRepository;

    @Scheduled(cron = "50 42 14 1 8 *")
    public void adjustProductPrices() {
        System.out.printf("campaign started");
        LocalDate today = LocalDate.now();
        List<Campaign> activeSales = campaignRepository.findAllByStartDate(today);

        for (Campaign campaign : activeSales) {
            List<CampaignDiscount> discounts = campaign.getCampaignDiscounts();
            for (CampaignDiscount discount : discounts) {
                Product product = productRepository.findById(discount.getProductId()).orElse(null);
                if (product != null) {
                    double discountAmount =  (product.getCurrentprice() * (discount.getDiscount() / 100));
                    double newPrice = (product.getCurrentprice() - discountAmount);

                    if (newPrice >= 0) {
                        product.setCurrentprice(newPrice);
                        product.setDiscount((product.getDiscount()+discount.getDiscount()));
                        productRepository.save(product);
                        System.out.println(product);
//                        productService.saveHistory(product, newPrice, LocalDate.now(), discountAmount);
                        priceHistoryRepository.save(new PriceHistory(product, newPrice, discountAmount, LocalDate.now()));
                    }
                }
            }
        }
    }

   // @Scheduled(cron = "0 0 0 * * *")
    public void revertPrice(){
        LocalDate today = LocalDate.now();
        List<Campaign> endedSales = campaignRepository.findAllByEndDate(today);

        for (Campaign campaign : endedSales) {
            List<CampaignDiscount> discounts = campaign.getCampaignDiscounts();
            for (CampaignDiscount discount : discounts) {
                Product product = productRepository.findById(discount.getProductId()).orElse(null);
                if (product != null) {
                    LocalDate date = campaign.getStartDate();
                    PriceHistory priceHistory = priceHistoryRepository.findTopByProductIdAndDate(product.getId(), date);
                    if (priceHistory != null) {
                        double previousPrice = priceHistory.getDiscountPrice();
                        product.setCurrentprice(priceHistory.getPrice() + previousPrice);
                        productRepository.save(product);
                        System.out.println(product);
//                        productService.saveHistory(product, priceHistory.getPrice() + previousPrice, LocalDate.now(), priceHistory.getDiscountPrice());
                        priceHistoryRepository.save(new PriceHistory(product, priceHistory.getPrice() + previousPrice, priceHistory.getDiscountPrice(), LocalDate.now()));
                    }
                }
            }
        }
    }
}
