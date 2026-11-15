
CREATE TABLE IF NOT EXISTS categoria (
id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL
);

INSERT INTO categoria (id, nombre) VALUES
(1, 'Guitarras Acústicas'),
(2, 'Guitarras Eléctricas'),
(3, 'Bajos Eléctricos'),
(4, 'Baterías'),
(5, 'Teclados y Pianos'),
(6, 'Amplificadores'),
(7, 'Micrófonos'),
(8, 'Pedales de Efectos'),
(9, 'Accesorios'),
(10, 'Estudio y Grabación');