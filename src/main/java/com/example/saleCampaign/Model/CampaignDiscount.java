package com.example.saleCampaign.Model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "campaign_discounts")
public class CampaignDiscount {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "campaign_id")
    @JsonBackReference
=======
    @JoinColumn(name = "campaign_id") 
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
    private Campaign campaign;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "discount")
    private float discount;

    @Override
    public String toString() {
        return "CampaignDiscount{" +
                "campaignId=" + (campaign != null ? campaign.getId() : "N/A") +
                '}';
    }

    public CampaignDiscount(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

}
