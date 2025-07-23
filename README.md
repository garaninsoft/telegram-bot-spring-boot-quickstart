# Telegram Bot на Spring Boot — Шаблон за Вечер

Этот проект — минимальный, но профессионально структурированный шаблон Telegram-бота на Spring Boot. Подходит для:

* Быстрого старта с Telegram API
* Новичков, изучающих Spring Boot и REST API
* Создания MVP-ботов с логикой обработки команд

---

## ✨ Возможности

* ✉️ Обработка Webhook-запросов Telegram
* ⚙️ Поддержка команд `/start` и `/calc`
* ⌛ Простой калькулятор с командами типа `/calc 2 * 3`
* 🌐 REST API с логированием и разделением ответственности (Controller / Service / Client)

---

## 🌐 Быстрый старт

### 1. Клонируй репозиторий

```bash
git clone https://github.com/yourname/telegram-bot-spring-boot-quickstart.git
cd telegram-bot-spring-boot-quickstart
```

### 2. Установи переменные окружения

Создай файл `.env` (или экспортируй вручную):

```env
TELEGRAM_BOT_TOKEN=your_token_here
```

### 3. Запусти приложение

```bash
./gradlew bootRun
```

### 4. Настрой Telegram Webhook

Используй `ngrok` для локального теста:

```bash
ngrok http 8080
```

Установи Webhook:

```bash
curl -X POST \
  https://api.telegram.org/bot<YOUR_BOT_TOKEN>/setWebhook \
  -d url=https://<your-ngrok-url>/webhook
```

---

## 🔧 Структура проекта

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

## ✉️ Команды, которые понимает бот

* `/start` — Приветствие и инструкция
* `/calc` — Простое вычисление. Пример:

```
/calc 10 / 2
/calc 5 * 6
```

---

## 🎖️ Идеи для доработки

* Поддержка кнопок и inline-режима
* Сохранение истории сообщений
* Docker-образ для деплоя
* Обработка других типов обновлений (фото, голос и т.д.)

---

## 🎁 Лицензия

MIT — свободно использовать, дорабатывать и продавать как часть своих продуктов.

---

## ☕ Автор

Создан с любовью и сжатием времени — специально для тех, кто хочет:

* понять Telegram API с нуля
* зарабатывать на разработке
* запускать продукты быстро

Telegram: [@garanin\_soft](https://t.me/garanin_soft)

---

✅ Готово к публикации на Gumroad или GitHub Marketplace!
