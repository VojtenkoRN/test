\connect test_db;
DROP SCHEMA IF EXISTS test CASCADE;
CREATE SCHEMA test;
ALTER SCHEMA test OWNER TO test_usr;
ALTER DATABASE test_db SET search_path TO test;

CREATE EXTENSION "uuid-ossp";