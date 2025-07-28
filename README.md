# Telegram Bot on Spring Boot — Evening-Ready Starter Template

This project is a **minimal yet professionally structured Spring Boot template** for Telegram bots.

* Quickly starting with the **Telegram API**
* Beginners learning **Spring Boot** and **REST API**
* Creating MVP bots with basic command-handling logic

---

## ✨ Features (Free Version)

- ✉️  Handles Telegram Webhook requests
- ⚙️  Supports `/start` and `/calc` commands
- ⌛  Simple calculator: `/calc 2 * 3`
- 🌐  REST API with clean architecture (Controller / Service / Client)
- 🧪  Ready to run locally in minutes

---

## 🚀 Full Version on Gumroad

The [Gumroad edition](https://garaninsoft.gumroad.com/l/telegram-bot-quickstart) includes **additional tools and upgrades**:

### 🔹 Basic (€5)
- Full source code
- Setup documentation

### 🔥 Pro (€15)
- Everything from Basic, plus:
    - 🐳 Dockerfile and `docker-compose.yml`
    - ✅ GitHub Actions (CI)

### 🎓 Support (€49)
- Everything from Pro, plus:
    - 🛠️ Personal help with deployment (Docker, VPS, etc.)
    - 🔧 Project extension advice
    - 💬 Telegram/Web support (1–2 day response)

➡️ [Get it now on Gumroad →](https://garaninsoft.gumroad.com/l/telegram-bot-quickstart)

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

⚠️ If you see a build error, you may be using ~~JDK 21+~~.
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

## 🎖️ Ideas for Extension

* ✅ Add buttons and inline support
* 🧾 Save message history
* 🐳 Build and deploy Docker image
* 🎧 Handle voice, photo, other updates

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
📦 Need a ready-to-use Telegram Bot on Spring Boot?
📦 Ready-to-use Telegram Bot template for Java devs — Get it on Gumroad:

👉 https://garaninsoft.gumroad.com/l/telegram-bot-quickstart

---


