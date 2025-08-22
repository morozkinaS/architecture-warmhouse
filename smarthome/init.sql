--- таблица для сенсоров
CREATE TABLE IF NOT EXISTS sensors (
                                       id SERIAL PRIMARY KEY,
                                       sensor_id VARCHAR(10) NOT NULL UNIQUE,
    location VARCHAR(50) NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT NOW()
    );

--- тестовые данные
INSERT INTO sensors (sensor_id, location) VALUES
    ('1', 'Living Room') ON CONFLICT DO NOTHING,
    ('2', 'Bedroom') ON CONFLICT DO NOTHING,
    ('3', 'Kitchen') ON CONFLICT DO NOTHING;