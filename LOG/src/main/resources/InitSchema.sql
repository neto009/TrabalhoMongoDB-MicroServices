use projeto
db.createCollection("log", { capped: true, size: 1024, max: 50})