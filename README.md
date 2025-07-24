# Telegram Bot on Spring Boot — Evening-Ready Starter Template

This project is a minimal yet professionally structured Spring Boot template for Telegram bots. Perfect for:

* Quickly starting with the **Telegram API**
* Beginners learning **Spring Boot** and **REST API**
* Creating MVP bots with basic command-handling logic

---

## ✨ Features

* ✉️  Handles Telegram Webhook requests
* ⚙️ Built-in support for `/start` and `/calc` commands
* ⌛ Simple calculator for inputs like `/calc 2 * 3`
* 🌐 REST API with logging and clear separation of concerns (Controller / Service / Client)

---

## 🌐 Quick Start

### 1. Clone the repository

```bash
git clone https://github.com/garaninsoft/telegram-bot-spring-boot-quickstart.git
cd telegram-bot-spring-boot-quickstart
```

### 2. Add your bot token

Open `src/main/resources/application.yml` and paste your Telegram Bot Token::

```yaml
telegram:
  bot:
    token: your_token_here
```

### 3. Run the app

```bash
./gradlew bootRun
```

⚠️  If you see a build error, you may be using ~~JDK 21+~~.
We recommend switching to**java 21**.
Check your version: 
```bash
java -version
```
f it's ~~JDK 21+~~, switch with:
```bash
sdk install java 21.0.3-tem
sdk use java 21.0.3-tem
java -version
```

### 4. Set up Telegram Webhook

Use `ngrok` for local testing:

```bash
ngrok http 8080
```

Set the Webhook:

```bash
curl -X POST \
  https://api.telegram.org/bot<YOUR_BOT_TOKEN>/setWebhook \
  -d url=https://<your-ngrok-url>/webhook
```

---

## 🔧 Project Structure

```
src/main/java/org/example/telegrambot/
├── TelegramBotApplication.java
├── controller/TelegramWebhookController.java
├── service/TelegramService.java
├── client/TelegramClient.java
├── dto/
│   ├── Update.java
│   ├── Message.java
│   ├── Chat.java
│   ├── From.java
│   └── SendMessageRequest.java
```

---

## ✉️ Supported Commands

* `/start` — Greeting and instructions
* `/calc` — Simple calculations. Examples:

```
/calc 10 / 2
/calc 5 * 6
```

---

## 🎖️ Possible Improvements

* Add buttons and inline mode support
* Save message history
* Build a Docker image for deployment
* Support more update types (photo, voice, etc.)

---

## 🎁 License

MIT — free to use, modify, and sell as part of your own products.

---

## ☕ Author

Crafted with love and time efficiency — for those who want to:

* understand Telegram API from scratch
* earn money with development
* launch products quickly

Telegram: [@garanin\_soft](https://t.me/garanin_soft)

---

