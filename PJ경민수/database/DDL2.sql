DROP TABLE members;

CREATE TABLE members (
    member_id VARCHAR2(1000) PRIMARY KEY,
    member_password VARCHAR2(1000) NOT NULL,
    member_role NUMBER(1,0) CHECK (member_role IN (1))
);

CREATE TABLE admin (
    admin_id VARCHAR(50) PRIMARY KEY,
    admin_password VARCHAR(50) NOT NULL,
    admin_role NUMBER(1,0) CHECK (admin_role IN (0))
);

INSERT INTO admin (admin_id, admin_password, admin_role)
VALUES ('admin', 'admin', 0);

INSERT INTO members (member_id, member_password, member_role)
VALUES ('user', '1234', 1);

COMMIT;
SELECT *
FROM members;