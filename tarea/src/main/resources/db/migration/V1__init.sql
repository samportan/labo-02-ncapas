CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE subscription (
                              id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                              type VARCHAR(50),
                              start_date DATE,
                              end_date DATE
);

CREATE TABLE "user" (
                        id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                        name VARCHAR(255),
                        subscription_id UUID UNIQUE,
                        CONSTRAINT fk_subscription FOREIGN KEY (subscription_id) REFERENCES subscription(id)
);

CREATE TABLE device (
                        id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                        type VARCHAR(100),
                        serial_number VARCHAR(100),
                        user_id UUID,
                        CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES "user"(id)
);

