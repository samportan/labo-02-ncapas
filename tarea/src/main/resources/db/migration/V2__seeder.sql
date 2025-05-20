CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO subscription (type, start_date, end_date) VALUES
                                                          ('Free', '2024-01-01', '2024-06-30'),
                                                          ('Premium', '2024-03-01', '2025-03-01'),
                                                          ('Enterprise', '2024-05-01', '2025-05-01');

INSERT INTO "user" (name, subscription_id)
SELECT 'Alice Johnson', id FROM subscription WHERE type = 'Free'
UNION ALL
SELECT 'Bob Smith', id FROM subscription WHERE type = 'Premium'
UNION ALL
SELECT 'Charlie Brown', id FROM subscription WHERE type = 'Enterprise';

INSERT INTO device (type, serial_number, user_id)
SELECT 'Phone', 'SN-1001', id FROM "user" WHERE name = 'Alice Johnson'
UNION ALL
SELECT 'Laptop', 'SN-2001', id FROM "user" WHERE name = 'Bob Smith'
UNION ALL
SELECT 'Tablet', 'SN-3001', id FROM "user" WHERE name = 'Charlie Brown'
UNION ALL
SELECT 'Smartwatch', 'SN-3002', id FROM "user" WHERE name = 'Charlie Brown';
