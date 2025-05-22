# 🔗 URL Shortener App 🚀

A minimal and efficient **URL Shortener Web Application** built with **Java Spring Boot**, **JPA**, and **Swagger**. It takes a long URL and returns a 7-character **alphanumeric** short URL that you can share easily! 🧩

---

## 🛠️ Tech Stack

- ☕ **Java 17**
- 🌱 **Spring Boot 3**
- 🧬 **Spring Data JPA**
- 🗃️ **SQL Server** (or any RDBMS via JPA)
- 🔍 **Swagger UI** (API documentation)
- 🧪 **Flyway** (optional for DB migration)

---

## ⚙️ Features

- 🔗 Generate 7-character short URLs using **Base62 alphanumeric hashing**
- 🔁 Redirect short URL to the original long URL
- 🛡️ Avoid duplicates (same long URL → same short URL)
- 📖 API docs available via Swagger UI
- 💾 Persistent storage using JPA with SQL Server

---

## 🚀 How It Works

1. Submit a long URL via the API or UI
2. App stores the original URL and generates a short code (like `a1B2c3D`)
3. Accessing `/a1B2c3D` redirects you to the original long URL

---

## 📁 Project Structure
src
├── main
│ ├── java
│ │ └── com.example.urlshortener
│ │ ├── controller
│ │ ├── service
│ │ ├── model
│ │ ├── repository
│ │ └── config
│ └── resources
│ └── application.properties

yaml
Copy
Edit

---

## 🔍 Swagger UI

After running the app, go to:

This provides a visual interface to test your API endpoints.

---

## 💻 API Endpoints

| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| POST   | `/api/shorten`        | Generate short URL           |
| GET    | `/{shortCode}`        | Redirect to original URL     |
| GET    | `/swagger-ui/index.html` | API documentation UI      |

---

## 🧪 Sample JSON

**Request:**
```json
POST /api/shorten
{
  "originalUrl": "https://www.example.com/very/long/url"
}
{
  "shortCode": "a1B2c3D",
  "shortUrl": "http://localhost:8080/a1B2c3D"
}
CREATE TABLE short_url (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  original_url VARCHAR(2048),
  short_code VARCHAR(7) UNIQUE
);
# Clone the project
git clone https://github.com/narayan-bhattarai/UrlShortner.git
cd UrlShortner

# Run using Spring Boot
./mvnw spring-boot:run
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=JavaDemo
spring.datasource.username=sa
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
🤝 Contributing
Contributions, issues and feature requests are welcome!
Feel free to check the issues page.

📜 License
This project is MIT licensed.

💡 Future Enhancements
📊 Analytics dashboard (clicks, sources)

🔐 User authentication

⏳ Expiry dates for short URLs

🗑️ URL deletion / admin dashboard

✨ Made with Java & ❤️ by Narayan Bhattarai

