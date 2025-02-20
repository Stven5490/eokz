-- Actualizar un producto
UPDATE Productos
SET descripcion = :descripcion,
    material = :material,
    color = :color,
    precio = :precio,
    stock = :stock
WHERE codigo = :codigo;