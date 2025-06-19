# ✉️ Email Assistant – AI-Powered Gmail Chrome Extension

**Email Assistant** is a smart Chrome Extension that integrates seamlessly into Gmail. It generates intelligent, tone-specific email replies using Google’s **Gemini AI** and a Java **Spring Boot** backend — saving time and improving productivity for professionals.

---

## 🚀 Features

- 🧠 **Smart Reply Generation**: Generates AI-powered email replies using the Gemini API.
- 🎯 **Tone Selection**: Choose between Formal, Casual, and Friendly tones before generating.
- 📤 **One-Click Send**: Generated replies are auto-filled into Gmail, ready to send.
- 🧩 **DOM Injection**: Uses MutationObserver to inject buttons directly into Gmail's UI.
- 🔗 **Spring Boot Backend**: Handles communication with Gemini API securely.

---

## 📸 Screenshots

| AI Reply Button Injected | Generated Response Example |
|--------------------------|-----------------------------|
| ![AI Reply Button](./screenshots/ai-reply.png) | ![AI Generated Email](./screenshots/generated-email.png) |

---

## 🛠️ Tech Stack

| Layer        | Technology                        |
|-------------|------------------------------------|
| Frontend     | JavaScript, HTML, CSS, Chrome Extension API |
| Backend      | Java 17, Spring Boot, REST API    |
| AI Engine    | Google Gemini API (Generative AI) |
| Tools        | VS Code, Postman, Git, GitHub     |
| Tested On    | Chrome Browser                    |

---

## 📦 Project Structure

📁 extension/
├── manifest.json
├── content.js
├── content.css

📁 backend/
├── controller/
├── service/
├── dto/
└── EmailAssistantApplication.java

yaml
Copy code

---

## ⚙️ Setup & Run Locally

### 1️⃣ Clone the Repo

```bash
git clone https://github.com/Vivekkumar5829/Email-Assistant.git
cd Email-Assistant
2️⃣ Start the Backend (Spring Boot)
bash
Copy code
cd backend
./mvnw spring-boot:run
By default, it runs at: http://localhost:8080

3️⃣ Load Chrome Extension
Go to chrome://extensions/

Enable Developer Mode

Click Load unpacked

Select the extension/ folder

4️⃣ Open Gmail and Click "Reply"
You’ll see a new button: AI Reply
Choose the tone, click Generate — your reply appears instantly!

🧠 How It Works
User opens Gmail and hits Reply.

MutationObserver detects the reply box and injects:

A "Generate" button

A Tone dropdown

On click, content + tone are sent to the Spring Boot API.

The backend calls Gemini, formats the reply, and sends it back.

The reply is injected into the Gmail textbox, ready to send.

🔐 Permissions
json
Copy code
"host_permissions": [
  "*://mail.google.com/*",
  "http://localhost:8080/*"
]
No sensitive user data is collected or stored.

📄 License
This project is free to use and modify under the MIT License.

🙌 Author
Vivek Kumar
GitHub | LinkedIn

⭐ Star the repo if you find this useful!
yaml
Copy code

---

### ✅ Bonus: Add These Assets
- Create a folder `screenshots/` in the root directory
- Save key screenshots:
  - `ai-reply.png` → Image of AI Reply button
  - `generated-email.png` → Image showing generated email response

---

Let me know if you'd like:
- A **LICENSE** file (MIT or Apache 2.0)?
- A **GitHub Actions workflow** for auto-lint or testing?
- A cleaned up `.gitignore` optimized for Java + extensions?

You're ready to open source this like a pro! 🚀
