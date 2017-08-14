INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (1, 'ROLE_ADMIN');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (2, 'ROLE_MANAGER');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (3, 'ROLE_CLIENT');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (4, 'ROLE_ANONYM');

INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('admin', 'admin', 'lmerm@mail.ru', 'Ludmila', 'Ermakova', '1993-10-07', 1);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('manager', 'manager', 'manager@mail.ru', 'Manager', 'Manager', '2017-07-18', 2);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('client', 'client', 'client@mail.ru', 'Client', 'Client', '2017-07-18', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('lmerm', 'password', 'lusinda_erm@mail.ru', 'Ludmila', 'Ermakova', '2000-06-01', 3);

INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID) VALUES ('Russia', 'Moscow', 'Moscow', 'Red street, 5', '234234', 3);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID) VALUES ('Germany', 'Berlin', 'Berlin Wedding', 'Genslerstrasse 84', '13359', 2);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID) VALUES ('Russia', 'St.Petersburg', 'St.Petersburg', 'Nevskiy pr. 5, 4', '123135', 4);

INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME) VALUES ('No category');
INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME) VALUES ('Non-professional');
INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME) VALUES ('Professional');

INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Await');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Given to courier');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('In progress');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Sent');

INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('DHL');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('EMC');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('Post');

INSERT INTO MYSHOP_SCHEMA.PAY_WAY (NAME) VALUES ('Card');
INSERT INTO MYSHOP_SCHEMA.PAY_WAY (NAME) VALUES ('On delivery arrived');

INSERT INTO MYSHOP_SCHEMA.PROPERTY_GROUP (PROPERTY_GROUP_ID, NAME, SOLO) VALUES (1, 'Camera', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY_GROUP (PROPERTY_GROUP_ID, NAME, SOLO) VALUES (2, 'Brand', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY_GROUP (PROPERTY_GROUP_ID, NAME, SOLO) VALUES (3, 'Features', 0);

INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (3, 'FPV (First Person View)');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (3, 'Follow me');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (3, 'GPS');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (3, 'Waypoint');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (3, 'Headless mode');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (1, 'HD');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (1, '4K');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (1, 'FullHD');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (2, 'Syma');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (2, 'DJI');
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME) VALUES (2, 'Hubsan');

INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID) VALUES ('SYMA X5UW WIFI FPV With 720P HD Camera Altitude Hold Mode 2.4G 4CH 6-Axis Gyro RC Quadcopter RTF - Red', 20, 62.99, '32*32*7cm/12.59*12.59*2.75inches', '3.7V 500mAh Li-poly(Included)', 7, 40, 'X5UW equipped with HD cameras, lets you control the aircraft and enjoy taking pictures/video of the pleasure flights. With altitude hold mode, adopt the advanced barometer to automatically maintain flying altitude. With Headless Mode, there is no need to adjust the position of aircraft before flight. One press automatically take off or land, RC quadcopter will either take off or go back to the position where it took off. A key 360Â° roll, continuous roll for perfect actionand wonderful performance. Open the "SYMA GO" App, use flight plan at your fingertips: just draw a route on the screen, the copter will auto pilot as per the given path. Unique remote control function of App, enables the users to experience the new fun of flying, to fly your drone even without the transmitter. X5UW is outfitted with multi-color LED lights, making the flight more spectacular especially in the dark. Up/down,left/right side-ward fight,forward/backward,turn left/right,with gyro/flash lights,A 360-degree roll and special functions(continuous rolling).', 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID) VALUES ('Redpawz R010 Mini RC Quadcopter RTF + Extra 3.7V 260mAh Li-po Battery - Blue', 25, 18.99, '8.5 X 8.5 X 5cm', '3.7V 260mAh 30C(Included)', 6, 30, 'The ducts do an excellent job in shielding the props from damage. Headless mode ensures that the quadcopter will always follow controls from your perspective all the time, regardless of which way the quad is facing. Makes your aircraft turning around, let''s enjoy more fun of rolling. With 49000RPM high-intensity 716 motor provide strong power. Built-in 6 axis gyro, strong stability, easily implement various flight movements, stronger wind resistance, easier to control. Fly for up to 6 minutes on a single charge. The creatively designed LED lights are fitted for night flight possibilities, leaving a beautiful landscape in the night sky.', 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID) VALUES ('Hubsan X4 Star Pro H507A WIFI FPV With 720P HD Camera GPS Waypoints Follow Me RC Quadcopter', 10, 85.99, '225 X 225 X 60mm', '7.6V 550mAh Li-po', 10, 100, 'Built in 720P HD camera are tuned amazingly to capture stunning pictures and videos from the sky. APP Waypoints allows for autonomous "autopilot" flights based on waypoints. With this function, easy to control and more relaxation and time to enjoy the flight experience. The Hubsan H507A features a GPS follow me mode. With Follow me mode, turns you into a mobile photographer with a personal cameraman. When enters into headless mode, the controls will be set to one direction based on the quadcopter`s current path. In failsafe mode, the flight control system will automatically control the quadcopter and bring it back to the Return To Home point and land. The RTH function can also be enabled directly from the transmitter, this will automatically bring the quadcopter to the Home point and land safely. The 550mAh capacity battery provides 10 minutes of satisfying flight on a sigle charge.', 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID) VALUES ('SYMA X20 Pocket 2.4G 4CH 6Aixs Altitude Hold Mode RC Quadcopter RTF - White', 30, 19.99, '10.5 X 10.5 X 2.5cm', '3.7V 180mAh', 5, 50, 'In altitude hold mode, the aircraft maintains a consistent altitude while allowing roll, pitch, and yaw to be controlled normally. One press automatically taking off or landing, rc quadcopter will take off or go back to the position where it took off. Headless mode ensures that the quadcopter will always follow controls from your perspective all the time, regardless of which way the quad is facing. Just press the button on transmitter, and you get 360-degrees Flip, continuous roll for perfect action and wonderful performance. The creatively designed LED lights are fitted for night flight possibilities, leaving a beautiful landscape in the night sky. Up / down / left turn / right turn / forward / back / left side fly / right side fly.', 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID) VALUES ('Hubsan X4 H501C Brushless 1080P HD Camera GPS Altitude Hold Mode RC Quadcopter RTF', 10, 159.99, ' 	22*22*7cm', '7.4V 2700mAh 10C', 20, 300, 'The built in HD camera are tuned amazingly to capture stunning pictures and video from the skies. The aerial live video and pictures give you a brand new view, shocking your mind. GPS system to guide the aircraft flying on the right route without missing the direction. GPS built-in, can lock the drone`s position,Hovering at a certain altitude. When enters into headless mode, the controls will be set to one direction based on the quadcopter`s current path. The Hubsan H501C features built-in GPS which enables the quadcopter to enter into a failsafe mode if the connection to the radio transmitter is lost. In failsafe mode, the flight control system will automatically control the quadcopter and bring it back to the Return To Home point and land. The RTH function can also be enabled directly from the transmitter, this will automatically bring the quadcopter to the Home point and land safely. Each motor is made by the superb technology, more powerful and more durable, the precise and self-tightening propellers help in a batter and safer flight. H501C is outfitted with multi-color LED lights, making the flight more spectacular especially in the dark.', 2);

INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('2016107016256123gql0k.jpg', 1);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('201707290105481iu25qdb.jpg', 2);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('50390_0.jpg', 3);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('Newest-Mini-Syma-font-b-X20-b-font-font-b-rc-b-font-font-b-helicopter.jpg', 4);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('db72c5c3-6895-43dc-9940-6141a284816c.jpg', 5);

INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (3, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (5, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (1, 13);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (4, 13);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (5, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (5, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (3, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (3, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (3, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (5, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (5, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (5, 1);

INSERT INTO MYSHOP_SCHEMA."ORDER" (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (2, 2, 1, 2, 1, '2017-08-07 01:20:09');
INSERT INTO MYSHOP_SCHEMA."ORDER" (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (3, 1, 2, 4, 2, '2017-08-07 01:24:50');
INSERT INTO MYSHOP_SCHEMA."ORDER" (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (3, 1, 1, 4, 1, '2017-08-07 01:25:06');
INSERT INTO MYSHOP_SCHEMA."ORDER" (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (3, 1, 2, 4, 3, '2017-08-07 01:25:33');
INSERT INTO MYSHOP_SCHEMA."ORDER" (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (4, 3, 1, 4, 2, '2017-08-07 01:26:35');
INSERT INTO MYSHOP_SCHEMA."ORDER" (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (3, 1, 1, 4, 1, '2017-08-07 01:29:08');

INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (2, 2, 1);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (3, 1, 1);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (1, 1, 2);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (2, 1, 2);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (4, 1, 2);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (5, 1, 2);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (2, 1, 3);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (1, 1, 4);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (4, 1, 4);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (5, 1, 4);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (2, 1, 5);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (3, 1, 5);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (4, 1, 5);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID) VALUES (1, 6, 6);









