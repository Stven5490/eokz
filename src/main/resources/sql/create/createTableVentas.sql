--Crear tabla de Ventas
CREATE TABLE IF NOT EXISTS tbl_Ventas(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL,
    valorTotal REAL NOT NULL,
    IVA REAL NOT NULL,
    valorRecibido REAL NOT NULL
);