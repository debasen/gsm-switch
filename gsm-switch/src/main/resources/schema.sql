create table USER_DETAIL (
EMAIL_ID VARCHAR(100) PRIMARY KEY,
USER_NAME VARCHAR(20) UNIQUE,
PASSWORD VARCHAR(20),
FIRST_NAME VARCHAR(50),
LAST_NAME VARCHAR(50),
ACTIVE BOOLEAN DEFAULT 'Y',
ROLE VARCHAR(10),
DEFAULT_DEVICE VARCHAR(50)
);

create table DEVICE_DETAIL(
DEVICE_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
SERIAL_NUMBER VARCHAR(50),
DEVICE_NAME VARCHAR(50),
MODEL_NUMBER VARCHAR(50),
RELAY BOOLEAN DEFAULT 'N',
DEVICE_RELAY BOOLEAN DEFAULT 'N',
DEVICE_FEEDBACK_RELAY BOOLEAN DEFAULT 'N',
OPERATING_FREQUENCY VARCHAR(5),
OPERATING_CURRENT VARCHAR(10),
DC_VOLTAGE VARCHAR(10),
AC_VOLTAGE VARCHAR(10),
IGBT_TEMPERATURE VARCHAR(10),
LAST_CONNECTED_DATE VARCHAR(20),
LAST_CONNECTED_TIME VARCHAR(20),
USER_EMAIL_ID VARCHAR(100),
SECURITY_KEY VARCHAR(50),
FOREIGN KEY (USER_EMAIL_ID) REFERENCES USER_DETAIL(EMAIL_ID)
);

create table STATUS_HISTORY(
ID BIGINT PRIMARY KEY AUTO_INCREMENT,
DEVICE_ID BIGINT,
OPERATING_FREQUENCY VARCHAR(5),
OPERATING_CURRENT VARCHAR(10),
DC_VOLTAGE VARCHAR(10),
AC_VOLTAGE VARCHAR(10),
IGBT_TEMPERATURE VARCHAR(10),
DATE VARCHAR(20),
TIME VARCHAR(20),
FOREIGN KEY (DEVICE_ID) REFERENCES DEVICE_DETAIL (DEVICE_ID)
);

alter table USER_DETAIL add FOREIGN KEY (DEFAULT_DEVICE) REFERENCES DEVICE_DETAIL (SERIAL_NUMBER);