-- Crear la tabla de productos
CREATE TABLE IF NOT EXISTS Productos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    codigo TEXT NOT NULL UNIQUE,
    descripcion TEXT NOT NULL,
    material TEXT NOT NULL,
    color TEXT NOT NULL,
    precio REAL NOT NULL,
    stock INTEGER NOT NULL
);