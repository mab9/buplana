-- uncomment for developing and testing
-- drop SCHEMA if exists buplana;
CREATE SCHEMA if not exists buplana;
GRANT ALL ON SCHEMA buplana TO "buplana-db-admin";

CREATE EXTENSION IF NOT EXISTS  "uuid-ossp";
