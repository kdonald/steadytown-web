CREATE TABLE members (
  id         INTEGER AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(64) NOT NULL,
  last_name  VARCHAR(64) NOT NULL,
  birth_date DATE NOT NULL);