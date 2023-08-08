-- Drop the table if it exists (for development/testing purposes)
DROP TABLE IF EXISTS app_user;

-- Create the table
CREATE TABLE app_user (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          username VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL
);
