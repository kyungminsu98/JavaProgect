CREATE TABLE book (
    isbn VARCHAR2(13) PRIMARY KEY,
    title VARCHAR2(100) NOT NULL,
    author VARCHAR2(50) NOT NULL,
    content VARCHAR2(300),
    stock NUMBER DEFAULT 0);
    
-- ���� 1
INSERT INTO book (isbn, title, author, content, stock)
VALUES ('9780141441151', '1984', 'George Orwell', 'George Orwell�� �Ҽ���, 1984��, �������� �Ⱓ�Ǿ����ϴ�.', 100);

-- ���� 2
INSERT INTO book (isbn, title, author, content, stock)
VALUES ('9780061120084', 'To Kill a Mockingbird', 'Harper Lee', 'Harper Lee�� �Ҽ���, 1960��, �̱����� �Ⱓ�Ǿ����ϴ�.', 150);

-- ���� 3
INSERT INTO book (isbn, title, author, content, stock)
VALUES ('9780544003415', 'The Lord of the Rings', 'J.R.R. Tolkien', 'J.R.R. Tolkien�� ��Ÿ�� �Ҽ���, 1954��~1955��, �������� �Ⱓ�Ǿ����ϴ�.', 80);

-- ���� 4
INSERT INTO book (isbn, title, author, content, stock)
VALUES ('9781451673319', 'To Kill a Mockingbird', 'Stephen King', 'Stephen King�� �Ҽ���, 1974��, �̱����� �Ⱓ�Ǿ����ϴ�.', 120);

-- ���� 5
INSERT INTO book (isbn, title, author, content, stock)
VALUES ('9781400079983', 'The Catcher in the Rye', 'J.D. Salinger', 'J.D. Salinger�� �Ҽ���, 1951��, �̱����� �Ⱓ�Ǿ����ϴ�.', 90);
COMMIT;

SELECT *  -- ���̺� Ȯ��
FROM book;

