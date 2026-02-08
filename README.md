<p align="center">
  <img src="https://docs.langchain4j.info/img/logo.svg" width="150" alt="langchain4j logo">
</p>

<h1 align="center">LangChain4j SpringBoot Starter</h1>

<p align="center">
  基于LangChain4j的 AI 应用脚手架，集成了流式对话、RAG 知识库、持久化记忆与函数调用。
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen.svg" alt="Spring Boot">
  <img src="https://img.shields.io/badge/LangChain4j-1.0.1--beta6-blue.svg" alt="LangChain4j">
  <img src="https://img.shields.io/badge/JDK-17+-orange.svg" alt="JDK">
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License">
</p>

---

## 🌟 平台简介

本项目是一个高度集成的 LangChain4j 示例项目，展示了如何在生产环境中将大模型（LLM）与 Java 生态系统无缝结合。

*   🚀 **高性能流式渲染**：采用 `Spring WebFlux` + `LangChain4j Reactor` 实现低延迟流式输出。
*   🧠 **持久化对话记忆**：自定义 `RedisChatMemoryStore` 实现多会话间的历史记录持久化。
*   📚 **自动化 RAG 引擎**：自动解析 [ragDocs/](src/main/resources/ragDocs/) 中的 PDF 文档，通过向量化存储于 Redis 向量数据库。
*   🛠️ **智能函数调用**：通过 `@Tool` 注解实现业务代码（如 [TimeTool.java](src/main/java/com/czu/langchain4j/tool/TimeTool.java)）的自动发现与调用。
*   🎨 **即刻可用 UI**：包含一个现代化的 [Chat UI](src/main/resources/static/index.html)，基于 Tailwind CSS。

## 🔥 核心特性

| 特性 | 说明 | 实现组件 |
| :--- | :--- | :--- |
| **LLM Model** | 支持 DeepSeek 等主流模型（OpenAI 兼容） | `StreamingChatLanguageModel` |
| **Embedding** | 阿里 DashScope text-embedding-v4 向量化 | `EmbeddingModel` |
| **Memory** | 基于 Redis 的对话上下文记忆 | [RedisChatMemoryStore.java](src/main/java/com/czu/langchain4j/config/RedisChatMemoryStore.java) |
| **Vector DB** | Redis Search 实现高效相似度检索 | `RedisEmbeddingStore` |
| **RAG** | PDF 解析与语义检索增强生成 | `EmbeddingStoreIngestor` |
| **Tool Use** | LLM 自动调用 Java 本地方法 | [TimeTool.java](src/main/java/com/czu/langchain4j/tool/TimeTool.java) |

---

## 🛠️ 技术栈清单

- **后端核心**: Java 17, Spring Boot 3.5.10
- **AI 框架**: LangChain4j 1.0.1-beta6
- **数据引擎**: Redis (Memory & Vector Store), MySQL
- **数据持久化**: MyBatis
- **文档解析**: Apache PDFBox
- **前端技术**: HTML5, Tailwind CSS

---

## 🚀 快速开始

### 1. 环境准备
- **Docker**: 推荐使用 [docker/docker-compose.yml](docker/docker-compose.yml) 快速启动 Redis。
- **Java**: JDK 17+。
- **Maven**: 3.8+。

### 2. 配置说明
在 [application-dev.yml](src/main/resources/application-dev.yml) 中配置你的 API Key：

```yaml
langchain4j:
  open-ai:
    streaming-chat-model:
      api-key: your-deepseek-api-key # DeepSeek 密钥
      base-url: https://api.deepseek.com
    embedding-model:
      api-key: your-dashscope-api-key # 阿里百炼密钥
```

### 3. 运行项目
```powershell
mvn clean compile spring-boot:run
```
项目启动后访问：[http://localhost:8080](http://localhost:8080)

---

## 📂 项目结构

```text
langchain4j/
├── docker/                 # 环境部署脚本
├── src/main/java/com/czu/langchain4j/
│   ├── config/             # LangChain4j 核心配置与 Redis 存储
│   ├── controller/         # AI 对话 API 入口
│   ├── service/            # 业务逻辑与 AI 服务定义
│   └── tool/               # LLM 可调用的原生工具类
├── src/main/resources/
│   ├── ragDocs/            # RAG 数据源目录（放置 PDF）
│   └── static/             # 后台管理与对话前端 UI
└── pom.xml                 # 依赖定义
```

---

## 🔗 参考资料
- [LangChain4j 官方文档](https://github.com/langchain4j/langchain4j)
- [DeepSeek 开发平台](https://platform.deepseek.com/)
- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)

---

<p align="right">
  Made with ❤️ by Copilot
</p>
