FROM postgres:10
ENV POSTGRES_USER moviedb
ENV POSTGRES_PASSWORD p4ssw0rd
ADD init.sql /docker-entrypoint-initdb.d
EXPOSE 5432