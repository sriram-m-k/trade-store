DELETE FROM trade_store;
INSERT INTO trade_store(id,trade_id,version,cp_id,book_id,maturity_date,created_date,expired) VALUES
 (2,'T10',1,'CP-1','B1',parsedatetime('20-05-2021', 'dd-MM-yyyy'),parsedatetime('29-08-2020', 'dd-MM-yyyy'),'N');
INSERT INTO trade_store(id,trade_id,version,cp_id,book_id,maturity_date,created_date,expired) VALUES
(3,'T11',2,'CP-2','B1',parsedatetime('20-05-2020', 'dd-MM-yyyy'),parsedatetime('29-08-2020', 'dd-MM-yyyy'),'N');
 INSERT INTO trade_store(id,trade_id,version,cp_id,book_id,maturity_date,created_date,expired) VALUES
(4,'T12',1,'CP-1','B1',parsedatetime('20-08-2019', 'dd-MM-yyyy'),parsedatetime('29-08-2020', 'dd-MM-yyyy'),'N');
INSERT INTO trade_store(id,trade_id,version,cp_id,book_id,maturity_date,created_date,expired) VALUES
(5,'T13',3,'CP-3','B2',parsedatetime('20-08-2018', 'dd-MM-yyyy'),parsedatetime('29-08-2020', 'dd-MM-yyyy'),'N');