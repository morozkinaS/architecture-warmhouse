

-- Создаём таблицу
CREATE TABLE IF NOT EXISTS sensors (
                                       id SERIAL PRIMARY KEY,
                                       sensor_id VARCHAR(10) NOT NULL UNIQUE,
    location VARCHAR(50) NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT NOW()
    );

-- Вставляем данные
INSERT INTO sensors (sensor_id, location) VALUES
                                              ('1', 'Living Room'),
                                              ('2', 'Bedroom'),
                                              ('3', 'Kitchen')
    ON CONFLICT (sensor_id) DO NOTHING;