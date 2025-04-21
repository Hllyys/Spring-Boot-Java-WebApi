IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='category' AND xtype='U')
CREATE TABLE category (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(55) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='product' AND xtype='U')
CREATE TABLE product (
    id INT IDENTITY(1,1) PRIMARY KEY,
    title VARCHAR(55) NOT NULL,
    price FLOAT NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category(id)
);
