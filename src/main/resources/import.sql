INSERT INTO tb_patient (name, email, phone) VALUES ('Kayk magalhaes', 'kayk@gmail.com', '999999999');
INSERT INTO tb_patient (name, email, phone) VALUES ('Eduarda', 'eduarda@gmail.com', '888888888');

INSERT INTO tb_speciality (name) VALUES ('Cardiologia');
INSERT INTO tb_speciality (name) VALUES ('Pediatria');
INSERT INTO tb_speciality (name) VALUES ('Clinico geral');

INSERT INTO tb_doctor (name, crm, price, speciality_id) VALUES ('Luciano', '465789/BA', '200.00', 1);
INSERT INTO tb_doctor (name, crm, price, speciality_id) VALUES ('Eduarda', '698342/SP', '555.00', 3);
INSERT INTO tb_doctor (name, crm, price, speciality_id) VALUES ('Izadora', '152478/MG', '500.00', 1);



INSERT INTO tb_appointment (moment, status, notes, patient_id, doctor_id) VALUES ('2026-09-10T14:00:00Z', 'CONFIRMED', 'Consulta de rotina', 1, 1);
INSERT INTO tb_appointment (moment, status, notes, patient_id, doctor_id) VALUES ('2026-09-10T14:00:00Z', 'CONFIRMED', 'Consulta de rotina', 2, 1);
INSERT INTO tb_appointment (moment, status, notes, patient_id, doctor_id) VALUES ('2026-09-15T10:30:00Z', 'PENDING', 'Retorno de exames', 2, 1);


