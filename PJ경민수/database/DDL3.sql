CREATE TABLE loan_history (
    loan_id INT IDENTITY PRIMARY KEY,
    isbn VARCHAR(13) NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,
    member_id VARCHAR(20) NOT NULL,
    FOREIGN KEY (isbn) REFERENCES book(isbn),
    FOREIGN KEY (member_id) REFERENCES member(member_id));