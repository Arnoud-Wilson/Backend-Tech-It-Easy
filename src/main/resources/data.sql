INSERT INTO television(ambi_light, available_size, bluetooth, original_stock, price, refresh_rate, smart_tv, sold, voice_control, wifi, brand, name, screen_quality, screen_type, type)
VALUES
    (true, 42, true, 5, 500, 100, true, 1, false, true, 'test', 'testéén', 'good', 'led', 'led'),
    (true, 42, true, 5, 400, 100, true, 2, false, true, 'test', 'testtwee', 'good', 'led', 'led');


INSERT INTO users (username, password, enabled, apikey, email) VALUES ('henk', /*TODO encrypted password (https://bcrypt-generator.com))*/, true, '7847493', "test@testy.tst");
INSERT INTO authorities (username, authority) VALUES ('henk', 'ROLE_ADMIN');