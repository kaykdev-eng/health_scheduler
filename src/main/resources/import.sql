INSERT INTO tb_patient (name, email, phone) VALUES ('Kayk magalhaes', 'kayk@gmail.com', '999999999');
INSERT INTO tb_patient (name, email, phone) VALUES ('Eduarda', 'eduarda@gmail.com', '888888888');

INSERT INTO tb_appointment (moment, status, notes, patient_id) VALUES ('2026-09-10T14:00:00Z', 'CONFIRMED', 'Consulta de rotina', 1);
INSERT INTO tb_appointment (moment, status, notes, patient_id) VALUES ('2026-09-15T10:30:00Z', 'PENDING', 'Retorno de exames', 2);