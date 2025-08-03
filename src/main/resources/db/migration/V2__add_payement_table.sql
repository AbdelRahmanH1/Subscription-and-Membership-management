CREATE TABLE payments
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id         BIGINT         NOT NULL,
    subscription_id BIGINT         NOT NULL,
    amount          DECIMAL(10, 2) NOT NULL,
    payment_date    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status          ENUM('SUCCESS', 'FAILED') DEFAULT 'SUCCESS',

    CONSTRAINT fk_payment_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_payment_subscription FOREIGN KEY (subscription_id) REFERENCES subscriptions (id) ON DELETE CASCADE
);
