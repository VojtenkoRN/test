psql -h localhost -U postgres -tc "SELECT 1 FROM pg_user WHERE usename = 'test_usr'" | grep -q 1 || psql -U postgres -c "CREATE USER test_usr WITH ENCRYPTED PASSWORD 'password';"