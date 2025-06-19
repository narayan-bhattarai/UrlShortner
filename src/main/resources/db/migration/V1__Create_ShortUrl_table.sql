CREATE TABLE short_url (
    id BIGINT IDENTITY PRIMARY KEY,
    short_code NVARCHAR(255) NOT NULL UNIQUE,
    original_url NVARCHAR(MAX) NOT NULL,
    created_at DATETIME
);

CREATE INDEX idx_short_code ON short_url(short_code);