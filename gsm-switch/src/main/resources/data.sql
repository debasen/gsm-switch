INSERT INTO USER_DETAIL values ('deb.sen93@gmail.com','deba','password','Debapriya','Sen','Y','ROLE_USER',NULL);
INSERT INTO USER_DETAIL values('biswa.sen@gmail.com','biswa','password','Biswapriya','Sen','Y','ROLE_ADMIN',NULL);

INSERT INTO DEVICE_DETAIL(SERIAL_NUMBER,DEVICE_NAME,MODEL_NUMBER,RELAY,DEVICE_RELAY,DEVICE_FEEDBACK_RELAY,USER_EMAIL_ID,SECURITY_KEY) values ('312312','Tesla-GSM','T-201','Y','Y','Y','deb.sen93@gmail.com','acee9');
INSERT INTO DEVICE_DETAIL(SERIAL_NUMBER,DEVICE_NAME,MODEL_NUMBER,RELAY,DEVICE_RELAY,DEVICE_FEEDBACK_RELAY,USER_EMAIL_ID,SECURITY_KEY) values ('312313','Basic-GSM','B-201','N','Y','Y','biswa.sen@gmail.com','0c59f');
INSERT INTO DEVICE_DETAIL(SERIAL_NUMBER,DEVICE_NAME,MODEL_NUMBER,RELAY,DEVICE_RELAY,DEVICE_FEEDBACK_RELAY,USER_EMAIL_ID,SECURITY_KEY) values ('312315','Tesla-GSM','T-201','Y','Y','Y','deb.sen93@gmail.com','3a3d5');
INSERT INTO DEVICE_DETAIL(SERIAL_NUMBER,DEVICE_NAME,MODEL_NUMBER,RELAY,DEVICE_RELAY,DEVICE_FEEDBACK_RELAY,SECURITY_KEY) values ('312316','Tesla-GSM','T-201','Y','Y','Y','3a3d5');
UPDATE USER_DETAIL SET DEFAULT_DEVICE='312312' where EMAIL_ID='deb.sen93@gmail.com';
UPDATE USER_DETAIL SET DEFAULT_DEVICE='312313' where EMAIL_ID='biswa.sen@gmail.com';