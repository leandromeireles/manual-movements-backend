## 🖥️ Back-end - Java + Spring Boot

### ✔️ Requisitos

* Java 17+
* Maven 3.8+
* IDE (IntelliJ, Eclipse, VSCode...)

### ▶️ Como rodar o projeto

1. Clone o repositório e entre na pasta `backend`:

   ```bash
   git clone https://github.com/leandromeireles/manual-movements-backend.git
   cd seu-repo-backend
   ```

2. Execute com sua IDE ou via terminal:

   ```bash
   ./mvnw spring-boot:run
   ```

3. A aplicação iniciará em:

   ```
   http://localhost:8080
   ```

4. Console do banco H2 (opcional):

   ```
   http://localhost:8080/h2-console
   ```

   **Credenciais do H2:**

    * JDBC URL: `jdbc:h2:mem:testdb`
    * User: `sa`
    * Password: *(vazio)*

### 🛠 Endpoints

* `GET /api/produtos`
* `GET /api/cosifs`
* `GET /api/movimentos`
* `POST /api/movimentos`

### 📁 Estrutura principal

```
backend
├── src
│   └── main
│       ├── java
│       │   └── com.api.movements
│       └── resources
│           ├── application.properties
│           └── ...
└── pom.xml
```

### ✅ Observações

* Os dados são armazenados em banco em memória (H2)
* O campo `usuario` é fixo com valor "TESTE"
* O campo `numeroLancamento` é gerado automaticamente
* Valores monetários com 3 casas decimais (ex: `13.500`)

### 🚫 .gitignore sugerido para backend

```
/target
/.idea
*.iml
*.log
*.class
.DS_Store
```
