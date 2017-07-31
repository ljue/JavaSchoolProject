
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (1, 'ROLE_ADMIN');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (4, 'ROLE_ANONYM');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (3, 'ROLE_CLIENT');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (2, 'ROLE_MANAGER');




INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('admin', 'admin', 'lmerm@mail.ru', 'Ludmila', 'Ermakova', '1993-10-07', 1);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('manager', 'manager', 'manager@mail.ru', 'Manager', 'Manager', '2017-07-18', 2);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('client', 'client', 'client@mail.ru', 'Client', 'Client', '2017-07-18', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('lmerm', 'password', 'lusinda_erm@mail.ru', 'Ludmila', 'Ermakova', '2000-06-01', 3);


INSERT INTO MYSHOP_SCHEMA.PROPERTY_GROUP (PROPERTY_GROUP_ID, NAME) VALUES (3, 'Features');

INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, GROUP_NAME) VALUES (3, 'FPV (First Person View)');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, GROUP_NAME) VALUES (3, 'Follow me');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, GROUP_NAME) VALUES (3, 'GPS');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, GROUP_NAME) VALUES (3, 'Waypoint');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, GROUP_NAME) VALUES (3, 'Headless mode');

INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME) VALUES ('No category');
INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME) VALUES ('Non-professional');
INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME) VALUES ('Professional');

INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, CATEGORY_ID, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION) VALUES ('MJX X708 Cyclone 2.4G 6Axis Gyro RC Quadcopter with 3D Flips Headless Mode RTF - White', 4, 34, 2, '31.5 x 31.5 x 6cm', '3.7V 550mAh(Included)', '8.5', '80', '');
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, CATEGORY_ID, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION) VALUES ('MJX X708 Cyclone 2.4G 6Axis Gyro RC Quadcopter with 3D Flips Headless Mode RTF - White', 3, 45, 2, '45', '3.7V 550mAh(Included)', '8.5', '89', '');
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, CATEGORY_ID, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION) VALUES ('MJX X708 Cyclone 2.4G 6Axis Gyro RC Quadcopter with 3D Flips Headless Mode RTF - White', 4, 34, 2, '31.5 x 31.5 x 6cm', '3.7V 550mAh(Included)', '8.5', '80', '');

INSERT INTO MYSHOP_SCHEMA.PAY_WAY (NAME) VALUES ('Card');
INSERT INTO MYSHOP_SCHEMA.PAY_WAY (NAME) VALUES ('On delivery arrived');

INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Not payed');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Waiting for payment');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Payed');

INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('In progress');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('Waiting for pick up');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('Waiting for assemble');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('Sent');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('Given to courier');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('Waiting for payment');

INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID) VALUES ('Russia', 'Moscow', 'Moscow', 'Red street, 5', '234234', 3);
