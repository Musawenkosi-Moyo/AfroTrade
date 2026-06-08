# AfroTrade - Multi-Vendor E-commerce Platform

AfroTrade is a scalable multi vendor e-commerce backend built using Spring Boot. It provides a comprehensive set of features for customers to browse and purchase products, and for sellers to manage their inventory and business details.

##  Features

###  Authentication & Security
- **Unified Auth Service**: A custom `UserDetailsService` handles both standard users and sellers using a unique `seller_` prefix strategy for email-based login.
- **JWT-based Authentication**: State-less security using JSON Web Tokens with embedded claims for `email` and `authorities`.
- **Role-Based Access Control (RBAC)**: Supports roles for `ROLE_CUSTOMER`, `ROLE_SELLER`, and `ROLE_ADMIN`.
- **OTP Verification**: Email-based One-Time Password (OTP) for account verification and secure login.

### Seller Management
- **Onboarding**: Sellers can register with business and bank details.
- **Verification**: Integrated email verification flow for new sellers.
- **Product Management**: Sellers can create, update, and delete their products.
- **Status Tracking**: Admin-controlled account status (e.g., PENDING, ACTIVE).

###  Customer Experience
- **Product Discovery**: Search and filter products by category, brand, color, size, and price.
- **Smart Cart**: Automatic calculation of `totalSellingPrice`, `totalMrpPrice`, and `discount` across multiple items.
- **Wishlist Management**: Personalized product sets for future consideration.
- **Review System**: Customers can provide feedback and ratings on products.

### 💳 Order & Payment
- **Order Processing**: Seamless transition from cart to order.
- **Transaction Tracking**: Comprehensive logging of transactions linking Customers, Orders, and Sellers.

## Core Entities

- **User & Seller**: Distinct profiles for marketplace participants.
- **Product**: Comprehensive model including pricing (MRP vs Selling), inventory tracking, multi-image support, and categorization.
- **Cart & CartItems**: Session-based item management with coupon code support.
- **WishList**: Many-to-Many relationship with Products.
- **Transaction**: Audit trail for all financial movements within the platform.

##  Tech Stack

- **Backend**: Java 17, Spring Boot 3.x
- **Security**: Spring Security 6, JWT (io.jsonwebtoken)
- **Security**: Spring Security, JWT (io.jsonwebtoken)
- **Persistence**: Spring Data JPA, Hibernate
- **Database**: MySQL
- **Communication**: Spring Mail (JavaMailSender)
- **Utilities**: Lombok, Maven

##  Prerequisites

- JDK 17 or higher
- Maven 3.x
- A database instance 
- SMTP credentials (for email features)

##  Configuration

### Environment Variables
The application is configured to look for the following environment variables:

| Variable | Description | Default |
| :--- | :--- | :--- |
| `MYSQL_HOST` | Database host | `localhost` |
| `server.port` | Application port | `5454` |

##  Getting Started

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   ```


3. **Build the project**:
   ```bash
   ./mvnw clean install
   ```
4. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

