# 🛍️ Sale-Campaign

## 📖 Overview  
The Sale Campaign Management System is a Java Spring Boot application designed to efficiently manage sales campaigns and a large product catalog of approximately 100,000 products. This system dynamically adjusts product prices during sales campaigns and provides APIs for querying product information, price history, and campaign details.

## ✨ Features  

- ✅ **Paginated Product Listing API**: Fetch product details with pagination and real-time price adjustments during sales.  
- ✅ **Campaign Management API**: Create and manage sales campaigns, including defining product-specific discounts.  
- 🔄 **Dynamic Price Adjustment**: Temporarily adjust product prices during active sales campaigns.  
- 🔍 **Query Features**:  
  1. Retrieve all products with dynamically adjusted prices.  
  2. Access the complete pricing history of each product.  
  3. Retrieve all campaigns (past, current, and upcoming).  

## 💻 Technologies Used  
- **Language & Framework**: Java with Spring Boot  
- **Database**: MySQL  

## 🔗 API Endpoints  

1. **Paginated Product API**  
Fetch a paginated list of products, including their MRP, current price, discount, and inventory.  

**Endpoint**: `GET /products?page={pageNumber}&pageSize={pageSize}`  
**Response Example**:  
```json
{
  "products": [
    {
      "id": "jeiu8f03",
      "mrp": 300,
      "currentPrice": 270,
      "discount": 10,
      "inventory": 2
    }
    // More product entries...
  ],
  "page": 1,
  "pageSize": 10,
  "totalPages": 2000
}
```

2. Sale Campaign Creation API
Create a new sale campaign with a title, start and end dates, and specific discounts for products.

Endpoint: POST /campaigns
Request Example:
```Json[]
{
  "startDate": "12/09/2023",
  "endDate": "17/09/2023",
  "title": "Diwali Discount",
  "campaignDiscount": [
    {
      "productId": "jeiu8f03",
      "discount": 10
    },
    {
      "productId": "jeiu8f02",
      "discount": 20
    }
  ]
}
```

3. Additional APIs
Additional APIs can be implemented to:

Retrieve the pricing history of a specific product.
Fetch details of all campaigns, categorized as past, current, or upcoming.

## 🏗️ Project Structure
```[]
src/
├── model/
│   ├── Campaign.java
│   ├── CampaignDiscount.java
│   ├── PriceHistory.java
│   ├── Product.java
│   └── ResponseDTO.java
├── repository/
│   ├── CampaignRepository.java
│   ├── PriceHistoryRepository.java
│   └── ProductRepository.java
<<<<<<< HEAD
|   └── CampaignDiscountRepositoty.java
=======
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
├── service/
│   ├── CampaignService.java
│   └── ProductService.java
├── controller/
│   ├── CampaignController.java
│   └── ProductController.java
└── scheduler/
    └── PriceAdjustMentSheduler.java
```
## ⚙️ Installation and Usage
### 📝 Prerequisites
- Java 17+
- Maven
- MySQL Database

## 🚀 Setup Instructions
1. Clone the Repository:
```bash[]
git clone https://github.com/your-username/sale-campaign-management-system.git
cd sale-campaign-management-system
```

2. Configure Database:
- Update application.properties with your MySQL configuration:
```properties[]
spring.datasource.url=jdbc:mysql://localhost:3306/sale_campaign_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Build the Application:
```bash[]
mvn clean install
```

4. Run the Application:
```bash[]
mvn spring-boot:run
```

5. Test the APIs: Use tools like Postman or cURL to interact with the APIs.

## Future Enhancements
- Implement a search feature for products.
- Add user authentication for managing campaigns.
- Develop frontend integration for campaign and product management.

## License
## 🚧 Future Enhancements
- 🔎 Implement a search feature for products.
- 🔐 Add user authentication for managing campaigns.
- 🖥️ Develop frontend integration for campaign and product management.

## 📜 License
- This project is licensed under the MIT License.

