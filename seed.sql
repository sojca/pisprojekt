use pis;
INSERT INTO DEPARTMENT (ID,  DESCRIPTION,  NAME) VALUES
(1, 'Department 1',  'Department1'), 
(2, 'Department2',  'Department2');

INSERT INTO ACTIVITY (ID,  DESCRIPTION,  DURATION,  NAME,  PRICEPERUNIT,  DEPARTMENT_ID) VALUES
(11, 'Programovanie v jazyku C', 1, 'Programovanie C', 1000, 1), 
(12, 'Testovanie', 1, 'Integracne testovanie', 1500, 2);

INSERT INTO COMPANY (ID,  ADDRESSLINE1,  ADDRESSLINE2,  CITY,  EMAIL,  ICO,  NAME,  STATE,  TELEPHONENUMBER,  ZIPCODE) VALUES
(8, 'Hybešova 42', '', 'Brno', 'test@test.cz', '42424242', '1. Testovacia',' CZ', '', 60200);

INSERT INTO COMMISSION (ID,  COCREATED,  COFINISHED,  STATUS,  COMPANY_ID) VALUES
(10, '2018-04-23 17:25:57.827', NULL, 'PARTLY_FINISHED', 8), 
(9, '2018-04-23 17:25:55.116', '2018-04-23 17:32:00.418', 'FINISHED', 8);

INSERT INTO COMMISSIONITEM (ID,  AMOUNT,  STATUS,  ACTIVITY_ID,  COMMISSION_ID) VALUES
(15, 20, 'PARTLY_FINISHED', 11, 10), 
(13, 15, 'FINISHED', 11, 9), 
(14, 5, 'FINISHED', 12, 9);

INSERT INTO EMPLOYEE (ID,  FIRSTNAME,  LOGIN,  PASSWORD,  ROLE,  SALARY,  SURNAME,  DEPARTMENT_ID) VALUES
(3, 'Donald', 'admin', 'test', 'ADMIN', 500, 'Admin', 1), 
(4, 'Branislav', 'manager', 'test', 'MANAGER', 500, 'Manager', 1), 
(5, 'Juraj', 'sojcak', 'test', 'EMPLOYEE', 150, 'Sojcak', 1), 
(6, 'Dusan', 'zeliar', 'test', 'EMPLOYEE', 150, 'Zeliar', 2), 
(7, 'Robert', 'manager1', 'test', 'MANAGER', 350, 'Manager', 2);

INSERT INTO COMMISSIONITEMEMPLOYEE (REALHOUR,  COMMISSIONITEM_ID,  EMPLOYEE_ID) VALUES
(12, 13, 5), 
(8, 15, 5), 
(6, 14, 6);

