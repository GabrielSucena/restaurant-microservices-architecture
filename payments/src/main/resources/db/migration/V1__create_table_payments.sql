CREATE TABLE payments (
    id BIGSERIAL PRIMARY KEY,
    payment_value NUMERIC(19, 2) NOT NULL,
    name VARCHAR(100),
    card_number VARCHAR(16),
    expiry_date VARCHAR(7),
    code VARCHAR(3),
    status VARCHAR(255) NOT NULL,
    payment_method_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL
);