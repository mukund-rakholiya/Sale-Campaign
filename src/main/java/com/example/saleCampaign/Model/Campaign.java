package com.example.saleCampaign.Model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
=======
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e

@Entity
@Table(name = "campaigns")
public class Campaign {
<<<<<<< HEAD
=======
 
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "campaign_name")
    private String campaignName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "campaign")
<<<<<<< HEAD
    @JsonManagedReference
=======
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
    private List<CampaignDiscount> campaignDiscounts;

    public Campaign(){
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "discounts=" + (campaignDiscounts != null ? campaignDiscounts.size() : 0) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<CampaignDiscount> getCampaignDiscounts() {
        return campaignDiscounts;
    }

    public void setCampaignDiscounts(List<CampaignDiscount> campaignDiscounts) {
        this.campaignDiscounts = campaignDiscounts;
    }
}
