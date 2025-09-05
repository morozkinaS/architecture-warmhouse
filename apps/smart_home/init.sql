-- Create the database if it doesn't exist
-- DROP DATABASE IF EXISTS smarthome;
-- CREATE DATABASE smarthome;

-- Create the sensors table
CREATE TABLE IF NOT EXISTS sensors (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    location VARCHAR(100) NOT NULL,
    value FLOAT DEFAULT 0,
    unit VARCHAR(20),
    status VARCHAR(20) NOT NULL DEFAULT 'inactive',
    last_updated TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
    );

-- Create indexes for common queries
CREATE INDEX IF NOT EXISTS idx_sensors_type ON sensors(type);
CREATE INDEX IF NOT EXISTS idx_sensors_location ON sensors(location);
CREATE INDEX IF NOT EXISTS idx_sensors_status ON sensors(status);

INSERT INTO sensors (name, type, location, value, unit, status) VALUES
                                                                    ('Living Room Temperature', 'temperature', 'living_room', 22.5, '°C', 'active'),
                                                                    ('Kitchen Temperature', 'temperature', 'kitchen', 21.8, '°C', 'active'),
                                                                    ('Bedroom Temperature', 'temperature', 'bedroom', 23.1, '°C', 'active'),
                                                                    ('Bathroom Temperature', 'temperature', 'bathroom', 24.2, '°C', 'active'),
                                                                    ('Front Door Light', 'light', 'entrance', 0, 'boolean', 'inactive'),
                                                                    ('Garage Door', 'door', 'garage', 0, 'boolean', 'inactive')
    ON CONFLICT DO NOTHING;