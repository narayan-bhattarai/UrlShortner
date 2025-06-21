CREATE TABLE "ShortUrl" (
    "Id" BIGINT IDENTITY PRIMARY KEY,
    "ShortCode" NVARCHAR(10) NOT NULL UNIQUE,
    "OriginalUrl" NVARCHAR(2048) NOT NULL UNIQUE,
    "CreatedAt" DATETIME
);

CREATE INDEX idx_short_code ON "ShortUrl"("ShortCode");