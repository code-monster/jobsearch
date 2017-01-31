
INSERT INTO vacancy (vacancy_name, company_name, creation_date, salary, location, description, original_link, provider) VALUES ('Senior Java Developer', 'MicroSoft Ukraine', '2016-12-20', 'NULL', 'Kharkov', 'Client is looking for a Senior Java consultant to assist with refinement of requirements, design and development and support of complex Java/JEE programs.
***Prefer applicants that are eligible for hire in the U.S. without visa sponsorship.A minimum of 7 years of Java development experience with complex, large scale, n-tiered applications using the following technologies is required: Java/JEE, HTML, JavaScript, Oracle, SQL, JSP, JSTL.', 'https://www.work.ua/jobs/1362915/', 'Emulate Parser');
INSERT INTO vacancy (vacancy_name, company_name, creation_date, salary, location, description, original_link, provider) VALUES ('Middle Java Developer', 'XWZ', '2016-12-20', 'NULL', 'Kharkov', 'MUST have a Bachelor Degree in a business, computer science, information systems or related field ', 'https://www.work.ua/jobs/1362900/', 'Emulate Parser');
INSERT INTO vacancy (vacancy_name, company_name, creation_date, salary, location, description, original_link, provider) VALUES ('Java EE dev', '', '2016-12-20', '10000', 'Kiev', 'amiliarity with UNIX scripting, performance tuning, database queries, and running UNIX operating systems, databases and web technologies is required. ', 'https://www.work.ua/jobs/136444/', 'Emulate Parser');
INSERT INTO vacancy (vacancy_name, company_name, creation_date, salary, location, description, original_link, provider) VALUES ('Java', 'x4', '2016-12-20', '110000', 'Kharkov', 'Must be able to obtain Position of Public Trust security clearance.', 'https://www.work.ua/jobs/888880/', 'Emulate Parser');


INSERT INTO ROLE(ROLE_NAME) VALUES ('admin');
INSERT INTO ROLE(ROLE_NAME) VALUES ('client');


INSERT INTO USER(LOGIN, PASSWORD, ROLE_ID) VALUES ('admin', '1234', 1);
INSERT INTO USER(LOGIN, PASSWORD, ROLE_ID) VALUES ('petya', 'qwerty', 2);
INSERT INTO USER(LOGIN, PASSWORD, ROLE_ID) VALUES ('vova', 'qwerty', 2);
INSERT INTO USER(LOGIN, PASSWORD, ROLE_ID) VALUES ('ulya', 'qwerty', 2);


