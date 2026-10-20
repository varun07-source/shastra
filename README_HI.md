# Shastra — Java AI Chatbot (starter project)

यह कॉलेज प्रोजेक्ट का शुरुआती working scaffold है: Java 17 + Spring Boot backend और HTML/CSS/JavaScript frontend.

## ज़रूरी चीज़ें
- JDK 17 या नया
- Maven 3.9+
- (वैकल्पिक) MySQL 8+
- AI API key, यदि असली AI replies चाहिए

## चलाने का तरीका
1. ZIP extract करें और `Shastra` folder खोलें।
2. Terminal में इसी folder से चलाएँ: `mvn spring-boot:run`
3. Browser में खोलें: `http://localhost:8080`
4. बिना API key के app demo mode में चलता है। असली AI replies के लिए `AI_API_KEY` environment variable सेट करें। चाहें तो `AI_MODEL` और `AI_BASE_URL` भी सेट करें।

### macOS / Linux
```bash
export AI_API_KEY="अपनी_API_KEY"
mvn spring-boot:run
```
### Windows PowerShell
```powershell
$env:AI_API_KEY="अपनी_API_KEY"
mvn spring-boot:run
```

## क्या शामिल है
- Chat UI और Spring Boot `/api/chat` endpoint
- Configurable OpenAI-compatible Chat Completions API integration
- Coding practice prompt section
- Feedback form (`/api/feedback`; starter version console में feedback log करता है)
- New chat और branch chat का UI starter
- Health topics पर सामान्य जानकारी देने के लिए system prompt guardrail

## अभी क्या अधूरा है / आगे क्या करें
यह पहला scaffold है, production-ready finished app नहीं:
- MySQL dependency और config placeholder मौजूद हैं, लेकिन chat history/feedback को database में persist करने के लिए schema और repository layer जोड़नी होगी।
- Branch chats का durable linking/context-sharing अभी UI placeholder है।
- API key को source code में न डालें और Git में commit न करें।
- किसी AI provider की API key, usage limits और billing अलग से लागू हो सकते हैं।
- Health replies diagnosis या treatment का विकल्प नहीं हैं।
- Production में authentication, input limits, rate limiting, error logging और privacy controls जोड़ें।

## API examples
`POST /api/chat`
```json
{"message":"Explain Java inheritance with an example","branchId":"main"}
```
`POST /api/feedback`
```json
{"rating":"Didn't understand","comment":"Please add another example","question":"What is inheritance?","answer":"..."}
```
