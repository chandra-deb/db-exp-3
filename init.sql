CREATE DATABASE IF NOT EXISTS score_management_system;

USE score_management_system;

CREATE TABLE students (
    sid INT PRIMARY KEY AUTO_INCREMENT,
    sname VARCHAR(20) NOT NULL,
    sgender ENUM ('male', 'female'),
    smajor VARCHAR(40),
    sbirthday DATE,
    scredit_points DECIMAL(5, 1)
);

CREATE TABLE teachers (
    tid INT PRIMARY KEY AUTO_INCREMENT,
    tname VARCHAR(20) NOT NULL,
    tschool VARCHAR(40)
);

CREATE TABLE courses (
    cid INT PRIMARY KEY AUTO_INCREMENT,
    cname VARCHAR(40) NOT NULL,
    ccredit_points DECIMAL(5, 1),
    tid INT NOT NULL,
    FOREIGN KEY (tid) REFERENCES teachers (tid)
);

CREATE TABLE scores (
    cid INT NOT NULL,
    sid INT NOT NULL,
    score DECIMAL(5, 2),
    PRIMARY KEY (cid, sid),
    FOREIGN KEY (cid) REFERENCES courses (cid),
    FOREIGN KEY (sid) REFERENCES students (sid)
);

INSERT INTO
    students (sname, sgender, smajor, sbirthday, scredit_points)
VALUES
    (
        'Alice',
        'female',
        'Computer Science',
        '2003-04-15',
        3.5
    ),
    (
        'Bob',
        'male',
        'Software Engineering',
        '2002-08-20',
        3.8
    ),
    (
        'Charlie',
        'male',
        'Artificial Intelligence',
        '2003-01-10',
        2.9
    );

INSERT INTO
    teachers (tname, tschool)
VALUES
    ('Zhang Juan', 'School of Computer Science'),
    ('Li Ming', 'School of Artificial Intelligence');

INSERT INTO
    courses (cname, ccredit_points, tid)
VALUES
    ('Database System & Application', 3.0, 1),
    ('Machine Learning', 4.0, 2),
    ('Operating System', 3.5, 1);

INSERT INTO
    scores (cid, sid, score)
VALUES
    (1, 1, 85.50),
    (2, 1, 90.00),
    (3, 1, 70.00),
    (1, 2, 58.00),
    (2, 2, 76.50),
    (3, 2, 60.00),
    (1, 3, 45.00),
    (2, 3, 50.00);