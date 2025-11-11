CREATE TABLE schedule (
    user_num INT NOT NULL,
    date DATE NOT NULL,
    comment VARCHAR(50),
    PRIMARY KEY (user_num, date)
);
