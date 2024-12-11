CREATE DATABASE IF NOT EXISTS flashcarddb;

USE flashcarddb;

/**
    Create tables
**/

CREATE TABLE box
(
    id        VARCHAR(255) NOT NULL,
    category  INT          NOT NULL,
    frequency INT          NOT NULL,
    created_at datetime     NULL,
    CONSTRAINT pk_box PRIMARY KEY (id)
);

ALTER TABLE box
    ADD CONSTRAINT uc_017004a29e9c36d308cb4bd76 UNIQUE (category);

CREATE TABLE IF NOT EXISTS card
(
    id       VARCHAR(255) NOT NULL,
    question VARCHAR(255) NULL,
    answer   VARCHAR(255) NULL,
    CONSTRAINT pk_card PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tag
(
    id   VARCHAR(255) NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_tag PRIMARY KEY (id)
);

ALTER TABLE tag
    ADD CONSTRAINT uc_f614e727ece81582cb882228a UNIQUE (name);


CREATE TABLE IF NOT EXISTS card_tag
(
    card_id VARCHAR(255) NOT NULL,
    tag_id  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_card_tag PRIMARY KEY (card_id, tag_id)
);

ALTER TABLE card_tag
    ADD CONSTRAINT fk_card_tag_on_card_entity FOREIGN KEY (card_id) REFERENCES card (id);

ALTER TABLE card_tag
    ADD CONSTRAINT fk_card_tag_on_tag_entity FOREIGN KEY (tag_id) REFERENCES tag (id);

/**
    Insertions
**/

INSERT INTO box (category, frequency) VALUES (1, 1);
INSERT INTO box (category, frequency) VALUES (2, 2);
INSERT INTO box (category, frequency) VALUES (3, 4);
INSERT INTO box (category, frequency) VALUES (4, 8);
INSERT INTO box (category, frequency) VALUES (5, 16);
INSERT INTO box (category, frequency) VALUES (6, 32);
INSERT INTO box (category, frequency) VALUES (7, 64);