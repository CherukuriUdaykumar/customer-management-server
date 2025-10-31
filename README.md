# 📋 Customer Management App

## 🚀 Overview
Customer Management App is a full-stack CRUD dashboard built with **ReactJS (Vite)** on the frontend and **Spring Boot** on the backend. It allows users to add, view, update, and delete customer records with a sleek, responsive UI and robust RESTful API.

---

## 🛠 Tech Stack

| Layer       | Technology                     |
|-------------|--------------------------------|
| Frontend    | ReactJS + Vite + Bootstrap 5   |
| Backend     | Java + Spring Boot             |
| Styling     | Custom CSS + Bootstrap Icons   |
| UX Features | Toast Notifications, Modals    |
| API Format  | RESTful                        |

---

## ✨ Features

- 🔄 Full CRUD operations for customer entities
- 📦 REST API integration with Spring Boot
- 🎨 Responsive and semi-official UI design
- ✅ Form validation with regex (email, names)
- 🔔 Toast notifications for feedback
- ⚠️ Confirmation modal before deletion
- 📊 Dynamic table with serial numbers (S.No)
- 🧩 Clean architecture with layered separation

---



## 🔗 API Endpoints

| Method | Endpoint                        | Description              |
|--------|----------------------------------|--------------------------|
| GET    | `/api/customers/all`            | Get all customers        |
| GET    | `/api/customers/{id}`           | Get customer by ID       |
| POST   | `/api/customers/create`         | Add new customer         |
| PUT    | `/api/customers/{id}`           | Update customer by ID    |
| DELETE | `/api/customers/{id}`           | Delete customer by ID    |

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/CherukuriUdaykumar/customer-management-server.git
cd customer-management-app
```
## Start the Spring Boot backend
```bash
cd customer-management-server
./mvnw spring-boot:run
Backend runs on http://localhost:8080
```
### 2. Install frontend dependencies

```bash
cd ../customer-management-app
npm install
cd client
npm install
npm run dev
Frontend runs on http://localhost:3000
```
### Swagger Documentation
You can access the Swagger API documentation for the backend at:http://localhost:8080/swagger-ui/index.html
### 3. Access the application
Open your browser and navigate to `http://localhost:3000` to access the Customer Management App.
---
## 🤝 Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.
---
## 📄 License
This project is licensed under the MIT License.
---

## 🙌 Credits

- Built with ❤️ by CHERUKURI UDAYKUMAR
- Powered by React, Spring Boot, and Bootstrap
-
Let me know if you want badges, deployment instructions, or a license section added next!

