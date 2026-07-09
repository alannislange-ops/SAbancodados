USE WeganosDB;
DROP DATABASE WeganosDB;
CREATE DATABASE WeganosDB;

lock tables CLIENTE READ;
lock tables CLIENTE write;

unlock tables ;
