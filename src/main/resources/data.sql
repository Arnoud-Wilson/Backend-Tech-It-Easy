INSERT INTO television(ambi_light, available_size, bluetooth, original_stock, price, refresh_rate, smart_tv, sold, voice_control, wifi, brand, name, screen_quality, screen_type, type)
VALUES
    (true, 42, true, 5, 500, 100, true, 1, false, true, 'test', 'testéén', 'good', 'led', 'led'),
    (true, 42, true, 5, 400, 100, true, 2, false, true, 'test', 'testtwee', 'good', 'led', 'led');


INSERT INTO users(username, password, enabled, apikey, email)
VALUES
    ('henk', '$2a$12$iiUqrEUaijdCKPL5E6KDS.CMtWtijnILgVUTHsCwROjlReyYrFf3W', true, '7847493', 'test@testy.tst');

-- //password van henk = Geheim // --

INSERT INTO authorities(username, authority)
VALUES
    ('henk', 'ROLE_ADMIN');
