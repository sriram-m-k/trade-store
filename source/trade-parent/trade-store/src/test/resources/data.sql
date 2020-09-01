DELETE FROM trade_store;
INSERT INTO trade_store(id,trade_id,version,cp_id,book_id,maturity_date,created_date,expired) VALUES
 (2,'T1',1,'CP-1','B1',parsedatetime('20-05-2021', 'dd-MM-yyyy'),parsedatetime('29-08-2020', 'dd-MM-yyyy'),'N');
INSERT INTO trade_store(id,trade_id,version,cp_id,book_id,maturity_date,created_date,expired) VALUES
(3,'T2',2,'CP-2','B1',parsedatetime('20-05-2022', 'dd-MM-yyyy'),parsedatetime('29-08-2020', 'dd-MM-yyyy'),'N');
 INSERT INTO trade_store(id,trade_id,version,cp_id,book_id,maturity_date,created_date,expired) VALUES
(4,'T2',1,'CP-1','B1',parsedatetime('20-08-2021', 'dd-MM-yyyy'),parsedatetime('29-08-2020', 'dd-MM-yyyy'),'N');
INSERT INTO trade_store(id,trade_id,version,cp_id,book_id,maturity_date,created_date,expired) VALUES
(5,'T3',3,'CP-3','B2',parsedatetime('20-08-2023', 'dd-MM-yyyy'),parsedatetime('29-08-2020', 'dd-MM-yyyy'),'N');