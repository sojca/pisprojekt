INSERT INTO department (id,  description,  name) VALUES
(1, 'Department 1',  'Department1'), 
(2, 'Department2',  'Department2');

INSERT INTO activity (id,  description,  duration,  name,  priceperunit,  department_id) VALUES
(11, 'Programovanie v jazyku C', 1, 'Programovanie C', 1000, 1), 
(12, 'Testovanie', 1, 'Integračné testovanie', 1500, 2);

INSERT INTO company (id,  addressline1,  addressline2,  city,  email,  ico,  name,  state,  telephonenumber,  zipcode) VALUES
(8, 'Hybešova 42', '', 'Brno', 'test@test.cz', '42424242', '1. Testovacia',' CZ', '', 60200);

INSERT INTO commission (id,  cocreated,  cofinished,  status,  company_id) VALUES
(10, '2018-04-23 17:25:57.827', NULL, 'PARTLY_FINISHED', 8), 
(9, '2018-04-23 17:25:55.116', '2018-04-23 17:32:00.418', 'FINISHED', 8);

INSERT INTO commissionitem (id,  amount,  status,  activity_id,  commission_id) VALUES
(15, 20, 'PARTLY_FINISHED', 11, 10), 
(13, 15, 'FINISHED', 11, 9), 
(14, 5, 'FINISHED', 12, 9);

INSERT INTO employee (id,  firstname,  login,  password,  role,  salary,  surname,  department_id) VALUES
(3, 'Donald, admin', 'test', 'ADMIN', 500, 'Admin', 1), 
(4, 'Branislav', 'manager', 'test', 'MANAGER', 500, 'Manager', 1), 
(5, 'Juraj', 'sojcak', 'test', 'EMPLOYEE', 150, 'Sojčák', 1), 
(6, 'Dušan', 'zeliar', 'test', 'EMPLOYEE', 150, 'Želiar', 2), 
(7, 'Robért', 'manager1', 'test', 'MANAGER', 350, 'Manager', 2);

INSERT INTO commissionitememployee (realhour,  commissionitem_id,  employee_id) VALUES
(12, 13, 5), 
(8, 15, 5), 
(6, 14, 6);

