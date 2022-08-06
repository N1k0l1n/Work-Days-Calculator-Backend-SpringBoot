CREATE TABLE days_off
(
    id   BIGINT   NOT NULL,
    date datetime NOT NULL,
    CONSTRAINT pk_days_off PRIMARY KEY (id)
);

CREATE TABLE users
(
    id      BIGINT       NOT NULL,
    name    VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    payment BIGINT       NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE working_day
(
    id      BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    date    date   NOT NULL,
    hours   BIGINT NOT NULL,
    CONSTRAINT pk_working_day PRIMARY KEY (id)
);