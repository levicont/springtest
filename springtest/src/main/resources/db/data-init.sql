INSERT INTO Contact (first_name, last_name, birth_date)
    VALUES ('Chris', 'Scheafer', '1981-05-03');
INSERT INTO Contact (first_name, last_name, birth_date)
    VALUES ('Scott', 'Tiger', '1990-11-02');
INSERT INTO Contact (first_name, last_name, birth_date)
    VALUES ('John', 'Smith', '1964-02-28');


INSERT INTO Contact_tel_detail (contact_id, tel_type, tel_number)
    VALUES ('1', 'Mobile', '19640228');
INSERT INTO Contact_tel_detail (contact_id, tel_type, tel_number)
    VALUES ('1', 'Home', '22240228');
INSERT INTO Contact_tel_detail (contact_id, tel_type, tel_number)
    VALUES ('2', 'Home', '33340228');


INSERT INTO hobby (hobby_id)
    VALUES ('Swimming');
INSERT INTO hobby (hobby_id)
    VALUES ('Jogging');
INSERT INTO hobby (hobby_id)
    VALUES ('Programming');
INSERT INTO hobby (hobby_id)
    VALUES ('Movies');
INSERT INTO hobby (hobby_id)
    VALUES ('Reading');

INSERT INTO Contact_hobby_detail (contact_id, hobby_id)
    VALUES (1,'Swimming');
INSERT INTO Contact_hobby_detail (contact_id, hobby_id)
    VALUES (1,'Movies');
INSERT INTO Contact_hobby_detail (contact_id, hobby_id)
    VALUES (2,'Swimming');