FROM postgres:10.23-alpine3.16

COPY base-datos.sh /docker-entrypoint-initdb.d/

RUN chmod +x /docker-entrypoint-initdb.d/*.sh
