\c market

\COPY admin_info FROM '/docker-entrypoint-initdb.d/999_dummy/csv/admin_info.csv' WITH CSV HEADER

\COPY buyer_info FROM '/docker-entrypoint-initdb.d/999_dummy/csv/buyer_info.csv' WITH CSV HEADER
