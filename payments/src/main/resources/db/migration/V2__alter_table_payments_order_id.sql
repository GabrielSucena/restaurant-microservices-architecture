ALTER TABLE payments
ALTER COLUMN order_id TYPE VARCHAR(255) USING order_id::VARCHAR(255);