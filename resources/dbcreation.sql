create database PCshop;
use PCshop;
CREATE TABLE IF NOT EXISTS cpu (
                                   id INT NOT NULL,
                                   name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DOUBLE(10, 3) NOT NULL,
    stock VARCHAR(255) NOT NULL,
    socket VARCHAR(255) NOT NULL,
    frequency INT NOT NULL,
    cores INT NOT NULL,
    threadspercore INT NOT NULL,
    PRIMARY KEY (id)
    );

select * from cpu;

CREATE TABLE IF NOT EXISTS gpu (
                                   id INT NOT NULL,
                                   name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DOUBLE(10, 3) NOT NULL,
    stock VARCHAR(255) NOT NULL,
    port VARCHAR(255) NOT NULL,
    memory INT NOT NULL,
    bandWidth INT NOT NULL,
    rgb BOOLEAN NOT NULL,
    PRIMARY KEY (id)
    );

select * from gpu;

CREATE TABLE IF NOT EXISTS hdd (
                                   id INT NOT NULL,
                                   name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DOUBLE(10, 3) NOT NULL,
    stock VARCHAR(255) NOT NULL,
    capacity DOUBLE(10,3) NOT NULL,
    rpm INT NOT NULL,
    formFactor VARCHAR(255) NOT NULL,
    connectionInterface VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );

select * from hdd;

CREATE TABLE IF NOT EXISTS psu (
                                   id INT NOT NULL,
                                   name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DOUBLE(10, 3) NOT NULL,
    stock VARCHAR(255) NOT NULL,
    power INT NOT NULL,
    alimentation INT NOT NULL,
    PRIMARY KEY (id)
    );

select * from psu;

CREATE TABLE IF NOT EXISTS ram (
                                   id INT NOT NULL,
                                   name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DOUBLE(10, 3) NOT NULL,
    stock VARCHAR(255) NOT NULL,
    capacity INT NOT NULL,
    frequency INT NOT NULL,
    memoryType VARCHAR(255) NOT NULL,
    rgb BOOLEAN NOT NULL,
    PRIMARY KEY (id)
    );

select * from ram;

CREATE TABLE IF NOT EXISTS ssd (
                                   id INT NOT NULL,
                                   name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DOUBLE(10, 3) NOT NULL,
    stock VARCHAR(255) NOT NULL,
    capacity DOUBLE(10,3) NOT NULL,
    formFactor VARCHAR(255) NOT NULL,
    connectionInterface VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );

select * from ssd;

CREATE TABLE IF NOT EXISTS supplier (
                                        id INT NOT NULL,
                                        name VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );

select * from supplier;

CREATE TABLE IF NOT EXISTS supplierproduct(
                                              id_supplier INT NOT NULL,
                                              id_product INT NOT NULL,
                                              PRIMARY KEY (id_supplier,id_product)
    );

select * from supplierproduct;