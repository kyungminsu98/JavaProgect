CREATE TABLE loanbook(
    loan_id NUMBER PRIMARY KEY, -- 대여정보 아이디
    isbn VARCHAR2(13),-- 고유번호
    member_id VARCHAR2(30),
    loan_date DATE NOT NULL, -- 대여날짜
    return_date DATE, --반납날짜
    FOREIGN KEY (isbn) REFERENCES book(isbn),
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);
DROP TABLE loanbook;

INSERT INTO book (loan_id, isbn, member_id, loan_date, return_date)
VALUES ('5', '9781400079983', 'user', '2024-03-24', '2024-03-27');
COMMIT;



SELECT *
FROM loanbook;
