CREATE TABLE loanbook(
    loan_id NUMBER PRIMARY KEY, -- �뿩���� ���̵�
    isbn VARCHAR2(13),-- ������ȣ
    member_id VARCHAR2(30),
    loan_date DATE NOT NULL, -- �뿩��¥
    return_date DATE, --�ݳ���¥
    FOREIGN KEY (isbn) REFERENCES book(isbn),
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);
DROP TABLE loanbook;

INSERT INTO book (loan_id, isbn, member_id, loan_date, return_date)
VALUES ('5', '9781400079983', 'user', '2024-03-24', '2024-03-27');
COMMIT;



SELECT *
FROM loanbook;
