# Docker 部署说明

## 目录结构
```
docker/
├── Dockerfile          # 应用容器构建文件
├── docker-compose.yml  # 服务编排文件
├── logs/              # 应用日志挂载目录
├── data/              # Redis 数据挂载目录
└── .gitignore         # Docker 相关忽略文件
```

## 使用方法

### 1. 构建项目
```bash
mvn clean package
```

### 2. 启动服务
```bash
cd docker
docker-compose up -d
```

### 3. 查看日志
```bash
docker-compose logs -f
```

### 4. 停止服务
```bash
docker-compose down
```

## 访问地址
- 应用: http://localhost:8080/chat?message=你好
- Redis: localhost:6379
- Redis Insight: localhost:8001

## 数据持久化
- 应用日志保存在 `docker/logs/` 目录
- Redis 数据保存在 `docker/data/` 目录