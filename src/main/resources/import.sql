INSERT INTO tb_patient (id, name, email, phone) VALUES ('63e8372c-9c91-44a9-b1ab-948635dc5ee8', 'Kayk magalhaes', 'kayk@gmail.com', '999999999');
INSERT INTO tb_patient (id, name, email, phone) VALUES ('87e9e118-881d-487e-baff-070f9c7ef30a', 'Eduarda', 'eduarda@gmail.com', '888888888');

INSERT INTO tb_speciality (id, name) VALUES ('3d0a5f63-eeba-42f8-bdea-299d7d60ba9b','Cardiologia');
INSERT INTO tb_speciality (id, name) VALUES ('fecbeed1-62ba-445c-bc47-e648c60bdadb','Pediatria');
INSERT INTO tb_speciality (id, name) VALUES ('39e8a8ef-04c2-4e1a-9f59-7fbf1ddeb4d1','Clinico geral');

INSERT INTO tb_doctor (id, name, crm, price, speciality_id) VALUES ('f183e0e2-a1c3-4d44-9b59-667fb9fabf0a', 'Luciano', '465789/BA', '200.00', '3d0a5f63-eeba-42f8-bdea-299d7d60ba9b');
INSERT INTO tb_doctor (id, name, crm, price, speciality_id) VALUES ('1e664bf7-2463-4944-8554-2251a5a7fb0f', 'Eduarda', '698342/SP', '555.00', 'fecbeed1-62ba-445c-bc47-e648c60bdadb');
INSERT INTO tb_doctor (id, name, crm, price, speciality_id) VALUES ('dded1f74-a3c7-4e2c-99a5-f8d150fdedba', 'Izadora', '152478/MG', '500.00', '39e8a8ef-04c2-4e1a-9f59-7fbf1ddeb4d1');



INSERT INTO tb_appointment (id, moment, status, notes, patient_id, doctor_id) VALUES (RANDOM_UUID(),'2026-09-10T14:00:00Z', 'CONFIRMED', 'Consulta de rotina', '63e8372c-9c91-44a9-b1ab-948635dc5ee8', 'f183e0e2-a1c3-4d44-9b59-667fb9fabf0a');
INSERT INTO tb_appointment (id, moment, status, notes, patient_id, doctor_id) VALUES (RANDOM_UUID(),'2026-09-10T14:00:00Z', 'CONFIRMED', 'Consulta de rotina', '87e9e118-881d-487e-baff-070f9c7ef30a', '1e664bf7-2463-4944-8554-2251a5a7fb0f');
INSERT INTO tb_appointment (id, moment, status, notes, patient_id, doctor_id) VALUES (RANDOM_UUID(),'2026-09-15T10:30:00Z', 'PENDING', 'Retorno de exames', '87e9e118-881d-487e-baff-070f9c7ef30a', 'f183e0e2-a1c3-4d44-9b59-667fb9fabf0a');


