FROM library/postgres
ENV POSTGRES_USER sales-api
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB postgres
COPY data.sql /docker-entrypoint-initdb.d/
