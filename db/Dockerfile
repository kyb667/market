FROM postgres:12.11

RUN localedef -i ja_JP -c -f UTF-8 -A /usr/share/locale/locale.alias ja_JP.UTF-8
ENV LANG ja_JP.utf8
ENV TZ=Asia/Tokyo

COPY ./shell /docker-entrypoint-initdb.d/
COPY ./sql /docker-entrypoint-initdb.d/
RUN chmod +x /docker-entrypoint-initdb.d/initdb.sh

USER postgres
