INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (1, 'ROLE_ADMIN');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (2, 'ROLE_MANAGER');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (3, 'ROLE_CLIENT');
INSERT INTO MYSHOP_SCHEMA.ROLE (ROLE_ID, NAME) VALUES (4, 'ROLE_ANONYM');

INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('admin', 'admin', 'admin@mail.ru', 'Ludmila', 'Ermakova', '1993-10-07', 1);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('manager', 'manager', 'lmerm@mail.ru', 'Manager', 'Manager', '1920-07-18', 2);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('client', 'client', 'client@mail.ru', 'Client', 'Client', '2017-07-18', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('lmerm', 'password', 'lusinda_erm@mail.ru', 'Ludmila', 'Ermakova', '2000-06-01', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('Yekaterina', 'client', 'katya-voroncova@yandex.ru', 'Yekaterina', 'Vorontsova', '1993-10-25', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('Stark', 'Stark', 'Stark@mail.ru', 'Arya', 'Stark', '2000-06-01', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('Jon', 'Jon', 'Jon@googl.com', 'Jon', 'Snow', '1992-07-05', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('Daenerys', 'Daenerys', 'Daenerys@googl.com', 'Daenerys', 'Targaryen', '1987-12-18', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('Tyrion', 'Tyrion', 'Tyrion@googl.com', 'Tyrion', 'Lannister', '1988-07-31', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('Lannister', 'Lannister', 'Lannister@googl.com', 'Jaime', 'Lannister', '1989-05-23', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('Sansa', 'Sansa', 'Sansa@googl.com', 'Sansa', 'Stark', '2000-06-01', 3);
INSERT INTO MYSHOP_SCHEMA.USER (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, BIRTHDAY, ROLE_ID) VALUES ('Khal', 'Khal', 'Khal@googl.com', 'Khal', 'Drogo', '1990-12-10', 3);


INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Russia', 'Moscow', 'Moscow', 'Red street, 5', '234234', 3, 0);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Germany', 'Berlin', 'Berlin Wedding', 'Genslerstrasse 84', '13359', 2, 0);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Russia', 'St.Petersburg', 'St.Petersburg', 'Nevskiy pr. 5, 4', '123135', 4, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Russia', 'St.Petersburg', 'St.Petersburg', 'Moskovskiy pr-t 198, 5', '123456', 1, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Russia', 'St.Petersburg', 'St.Petersburg', 'Balkanskaya 5', '123456', 8, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Turky', 'Alanya', 'Kargicak', 'Yoiu', '10721', 13, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Turky', 'Antalya', 'Antalya', 'Kale Caddesi', '15781', 14, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Turky', 'Antalya', 'Antalya', 'Kale', '70356', 15, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Bulgarya', 'Nesebar', 'Nesebar', 'Ulitsa Slavyanska, Obzor', '50587', 16, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Bulgarya', 'Nesebar', 'Nesebar', 'Ulitsa Slavyanska, Obzor', '50587', 16, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Bulgarya', 'Obzor', 'Obzor', 'Ulitsa Koral', '251608', 17, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Germany', 'Rheinland-Pfalz', 'Frankweiler', 'Brandenburgische Strasse 45', '76833', 3, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Bulgarya', 'Budva', 'Budva', 'Ulitsa Kiril i Metodiy20', '200816', 18, 1);
INSERT INTO MYSHOP_SCHEMA.ADDRESS (COUNTRY, REGION, CITY, STREET_ADDRESS, POST_INDEX, USER_ID, VISIBLE) VALUES ('Bulgarya', 'Varna', 'Varna', 'Ulitsa Farmasy', '333101', 19, 1);


INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME, VISIBLE) VALUES ('No category', 1);
INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME, VISIBLE) VALUES ('No professional', 1);
INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME, VISIBLE) VALUES ('Professional', 1);
INSERT INTO MYSHOP_SCHEMA.CATEGORY (NAME, VISIBLE) VALUES ('anti professional', 0);

INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Await');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Given to courier');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('In progress');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_STATUS (NAME) VALUES ('Sent');

INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('DHL');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('EMC');
INSERT INTO MYSHOP_SCHEMA.DELIVERY_WAY (NAME) VALUES ('Post');

INSERT INTO MYSHOP_SCHEMA.PAY_WAY (NAME) VALUES ('Card');
INSERT INTO MYSHOP_SCHEMA.PAY_WAY (NAME) VALUES ('On delivery arrived');

INSERT INTO MYSHOP_SCHEMA.PROPERTY_GROUP (NAME, SOLO, VISIBLE) VALUES ('Camera', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY_GROUP (NAME, SOLO, VISIBLE) VALUES ('Brand', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY_GROUP (NAME, SOLO, VISIBLE) VALUES ('Features', 0, 1);

INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (3, 'FPV (First Person View)', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (3, 'Follow me', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (3, 'GPS', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (3, 'Waypoint', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (3, 'Headless mode', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (1, 'HD', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (1, '4K', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (1, 'FullHD', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'Syma', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'DJI', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'Hubsan', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'Visuo', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'GTENG', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'JJRC', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'BAYANGTOYS', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'Eachine', 1);
INSERT INTO MYSHOP_SCHEMA.PROPERTY (PROPERTY_GROUP_ID, NAME, VISIBLE) VALUES (2, 'MJX', 1);

INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('SYMA X5UW WIFI FPV With 720P HD Camera Altitude Hold Mode 2.4G 4CH 6-Axis Gyro RC Quadcopter RTF - Red', 19, 62.99, '32*32*7cm/12.59*12.59*2.75inches', '3.7V 500mAh Li-poly(Included)', 7, 40, 'X5UW equipped with HD cameras, lets you control the aircraft and enjoy taking pictures/video of the pleasure flights. With altitude hold mode, adopt the advanced barometer to automatically maintain flying altitude. With Headless Mode, there is no need to adjust the position of aircraft before flight. One press automatically take off or land, RC quadcopter will either take off or go back to the position where it took off. A key 360Â° roll, continuous roll for perfect actionand wonderful performance. Open the "SYMA GO" App, use flight plan at your fingertips: just draw a route on the screen, the copter will auto pilot as per the given path. Unique remote control function of App, enables the users to experience the new fun of flying, to fly your drone even without the transmitter. X5UW is outfitted with multi-color LED lights, making the flight more spectacular especially in the dark. Up/down,left/right side-ward fight,forward/backward,turn left/right,with gyro/flash lights,A 360-degree roll and special functions(continuous rolling).', 2, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Redpawz R010 Mini RC Quadcopter RTF + Extra 3.7V 260mAh Li-po Battery - Blue', 15, 38.99, '8.5 X 8.5 X 5cm', '3.7V 260mAh 30C(Included)', 6, 30, 'The ducts do an excellent job in shielding the props from damage. Headless mode ensures that the quadcopter will always follow controls from your perspective all the time, regardless of which way the quad is facing. Makes your aircraft turning around, let''s enjoy more fun of rolling. With 49000RPM high-intensity 716 motor provide strong power. Built-in 6 axis gyro, strong stability, easily implement various flight movements, stronger wind resistance, easier to control. Fly for up to 6 minutes on a single charge. The creatively designed LED lights are fitted for night flight possibilities, leaving a beautiful landscape in the night sky.', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 Star Pro H507A WIFI FPV With 720P HD Camera GPS Waypoints Follow Me RC Quadcopter', 4, 85.99, '225 X 225 X 60mm', '7.6V 550mAh Li-po', 10, 100, 'Built in 720P HD camera are tuned amazingly to capture stunning pictures and videos from the sky. APP Waypoints allows for autonomous "autopilot" flights based on waypoints. With this function, easy to control and more relaxation and time to enjoy the flight experience. The Hubsan H507A features a GPS follow me mode. With Follow me mode, turns you into a mobile photographer with a personal cameraman. When enters into headless mode, the controls will be set to one direction based on the quadcopter`s current path. In failsafe mode, the flight control system will automatically control the quadcopter and bring it back to the Return To Home point and land. The RTH function can also be enabled directly from the transmitter, this will automatically bring the quadcopter to the Home point and land safely. The 550mAh capacity battery provides 10 minutes of satisfying flight on a sigle charge.', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('SYMA X20 Pocket 2.4G 4CH 6Aixs Altitude Hold Mode RC Quadcopter RTF - White', 48, 39.99, '10.5 X 10.5 X 2.5cm', '3.7V 180mAh', 5, 50, 'In altitude hold mode, the aircraft maintains a consistent altitude while allowing roll, pitch, and yaw to be controlled normally. One press automatically taking off or landing, rc quadcopter will take off or go back to the position where it took off. Headless mode ensures that the quadcopter will always follow controls from your perspective all the time, regardless of which way the quad is facing. Just press the button on transmitter, and you get 360-degrees Flip, continuous roll for perfect action and wonderful performance. The creatively designed LED lights are fitted for night flight possibilities, leaving a beautiful landscape in the night sky. Up / down / left turn / right turn / forward / back / left side fly / right side fly.', 2, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 H501C Brushless 1080P HD Camera GPS Altitude Hold Mode RC Quadcopter RTF', 9, 159.99, '22 x 22 x 7cm', '7.4V 2700mAh 10C', 20, 300, 'The built in HD camera are tuned amazingly to capture stunning pictures and video from the skies. The aerial live video and pictures give you a brand new view, shocking your mind. GPS system to guide the aircraft flying on the right route without missing the direction. GPS built-in, can lock the drone`s position,Hovering at a certain altitude. When enters into headless mode, the controls will be set to one direction based on the quadcopter`s current path. The Hubsan H501C features built-in GPS which enables the quadcopter to enter into a failsafe mode if the connection to the radio transmitter is lost. In failsafe mode, the flight control system will automatically control the quadcopter and bring it back to the Return To Home point and land. The RTH function can also be enabled directly from the transmitter, this will automatically bring the quadcopter to the Home point and land safely. Each motor is made by the superb technology, more powerful and more durable, the precise and self-tightening propellers help in a batter and safer flight. H501C is outfitted with multi-color LED lights, making the flight more spectacular especially in the dark.', 2, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('DJI Mavic Pro WIFI 4K UHD Camera GPS Obstacle Avoidance Mini Foldable Quadcopter RTF', 67, 999, '32.5x32.5x7cm', '3830 mAh', 27, 7000, 'The DJI Mavic Pro folds down as small as a bottle of water, making it small enough to bring with you everywhere.
True 4K, fully stabilized ensures smooth footage, 4K camera is supported by a miniaturized camera stabilization system that stabilizes the entire camera, letting you extract the most from every single pixel.
New OcuSync transmission system offers up to 4.3 miles (7km) of transmission range.
ActiveTrack, TapFly and other smart features make professional looking video effortless.
Obstacle Avoidance combined with sensor redundancy increases flight safety and reliability.
Vision positioning paired with GPS and GLONASS ensures precise positioning indoor and outdoors.
Fly at up to 40mph (64kmh) or for as long as 27-minutes.
The DJI GO app lets you see everything the camera sees, as well as everything you need to know about your Mavic, from battery life to where it is, where it''s heading, and much more.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('DJI Mavic Pro WIFI 4K UHD Camera GPS Obstacle Avoidance Mini Foldable Quadcopter RTF', 42, 999, '32.5x32.5x7cm', '3830 mAh', 27, 7000, 'The DJI Mavic Pro folds down as small as a bottle of water, making it small enough to bring with you everywhere.True 4K, fully stabilized ensures smooth footage, 4K camera is supported by a miniaturized camera stabilization system that stabilizes the entire camera, letting you extract the most from every single pixel.
New OcuSync transmission system offers up to 4.3 miles (7km) of transmission range.
ActiveTrack, TapFly and other smart features make professional looking video effortless.
Obstacle Avoidance combined with sensor redundancy increases flight safety and reliability.
Vision positioning paired with GPS and GLONASS ensures precise positioning indoor and outdoors.
Fly at up to 40mph (64kmh) or for as long as 27-minutes.
The DJI GO app lets you see everything the camera sees, as well as everything you need to know about your Mavic, from battery life to where it is, where it''s heading, and much more.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('VISUO XS809HW WIFI FPV With Wide Angle HD Camera High Hold Mode Foldable Arm RC Quadcopter RTF', 84, 52.99, '47x29.5x9cm', '3.7V 900mAh', 10, 90, 'With foldable arm, small size, easy to carry.
With altitude hold mode function provides stable flight.
With wifi function can be connected APP, APK system to take pictures, video, real-time transmission through the phone camera image.
With 2.0MP 720P wide angle camera  give wide range high denfinition pictures and video.
With 0.3MP camera capture pictures and record woderful moments.
With 3.7V 900mAh battery, the fly time up to 10 mins.
With Headless Mode,no need to adjust the position of aircraft before flying .
With One key to return function makes it easily to find the way home.
2.4GHz Technology Adopted for Anti-Interference.
4 Channel which can do ascend, descend, forward, backward, left sideward fly, right sideward fly and rolling 360Â°.
6-axis gyro which can have more stable flying and be easy to control.
It have 3-level flight speed to switch that can make more fun with the flying.
It can realize 3D tumbling 360Â°rolling in four directions with 4 LED lights.
The quadcopter fuselage is made of high strength and resistant engineering plastics,lightweight and durable resistance.', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('GTENG T911W WIFI FPV With 0.3MP HD Camera High Hold Mode Foldable Arm RC Quadcopter RTF', 34, 48, '47x29.5x9cm', '3.7V 450mAh', 7, 30, 'With foldable arm, small size, easy to carry.
With altitude hold mode function provides stable flight.
With wifi function can be connected APP, APK system to take pictures, video, real-time transmission through the phone camera image.
With 0.3MP camera capture pictures and record woderful moments.
With Headless Mode,no need to adjust the position of aircraft before flying .
With One key to return function makes it easily to find the way home.
2.4GHz Technology Adopted for Anti-Interference.
4 Channel which can do ascend, descend, forward, backward, left sideward fly, right sideward fly.
6-axis gyro which can have more stable flying and be easy to control.
It have 3-level flight speed to switch that can make more fun with the flying.
The quadcopter fuselage is made of high strength and resistant engineering plastics,lightweight and durable resistance.', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('GTENG T911W WIFI FPV With 0.3MP HD Camera High Hold Mode Foldable Arm RC Quadcopter RTF', 34, 48, '47x29.5x9cm', '3.7V 450mAh', 7, 30, 'With foldable arm, small size, easy to carry.
With altitude hold mode function provides stable flight.
With wifi function can be connected APP, APK system to take pictures, video, real-time transmission through the phone camera image.
With 0.3MP camera capture pictures and record woderful moments.
With Headless Mode,no need to adjust the position of aircraft before flying .
With One key to return function makes it easily to find the way home.
2.4GHz Technology Adopted for Anti-Interference.
4 Channel which can do ascend, descend, forward, backward, left sideward fly, right sideward fly.
6-axis gyro which can have more stable flying and be easy to control.
It have 3-level flight speed to switch that can make more fun with the flying.
The quadcopter fuselage is made of high strength and resistant engineering plastics,lightweight and durable resistance.', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('JJRC H26WH WIFI FPV With 2.0MP HD Camera Altitude Hold RC Quadcopter RTF', 37, 86, '60 x 60 x 17cm', '1200mAh', 10, 150, 'With WIFI FPV 2.0MP HD Camera.
With High Hold mode can set height.
Wifi real-time transmission FPV system which can capture photos and record videos for your great memory.
With attractive headless mode, completely solving pilot loss-of-orientation problem.
One key return function makes it easily to find the way home.
4 Channel which can do ascend, descend, forward, backward, left sideward fly, right sideward fly and rolling 360Â°
It has 6-axis gyro which can have more stable flying and be easy to control.
2.4G technology adopted for anti-interference, even more than one quadcopter is flying at the same time they will not interfere with each other.
Function: ascend / descend / forward / backward / side flying / 360Â°rolling action / LED / Camera / CF mode / One key return
', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('BAYANGTOYS X16 Brushless WIFI FPV With 2MP Camera Altitude Hold 2.4G 4CH 6Axis RC Quadcopter RTF', 35, 122, '50 x 50 x 19cm', '2200mAh', 14, 210, 'WIFI FPV with 2.0MP HD camera.
With automatic return function, the copter will automatic returning and landing when lost connection or signal received interference.
With attractive headless mode, completely solving pilot "loss of orientation" problems.
360 degree flip / rollover function makes your aircraft turning around and around likes a excited bird, let''s enjoy more fun of rolling.
2-mega-pixel HD camera give you a clear image / video as you were nearby.
Side flight function shows the good balance keeping performance and a big stunt potential.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('BAYANGTOYS X16 Brushless WIFI FPV With 2MP Camera Altitude Hold 2.4G 4CH 6Axis RC Quadcopter RTF', 35, 122, '50 x 50 x 19cm', '2200mAh', 14, 210, 'WIFI FPV with 2.0MP HD camera.
With automatic return function, the copter will automatic returning and landing when lost connection or signal received interference.
With attractive headless mode, completely solving pilot "loss of orientation" problems.
360 degree flip / rollover function makes your aircraft turning around and around likes a excited bird, let''s enjoy more fun of rolling.
2-mega-pixel HD camera give you a clear image / video as you were nearby.
Side flight function shows the good balance keeping performance and a big stunt potential.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('BAYANGTOYS X16 Brushless WIFI FPV With 2MP Camera Altitude Hold 2.4G 4CH 6Axis RC Quadcopter RTF', 35, 122, '50 x 50 x 19cm', '2200mAh', 14, 210, 'WIFI FPV with 2.0MP HD camera.
With automatic return function, the copter will automatic returning and landing when lost connection or signal received interference.
With attractive headless mode, completely solving pilot "loss of orientation" problems.
360 degree flip / rollover function makes your aircraft turning around and around likes a excited bird, let''s enjoy more fun of rolling.
2-mega-pixel HD camera give you a clear image / video as you were nearby.
Side flight function shows the good balance keeping performance and a big stunt potential.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('BAYANGTOYS X21 Brushless Double GPS WIFI FPV With 1080P Gimbal Camera RC Quadcopter', 25, 186, '25x25x22cm', '2200mAh', 14, 210, 'With 1080P HD gimbal camera.
GPS fixed point and set high.
Brushless Motor strong power to the quadcopter.
With attractive headless mode, completely solving pilot "loss of orientation" problems.
With automatic return function, the copter will automatic returning and landing when lost connection or signal received interference.
The gimbal can be adjusted.
With 2.4G Transmiter/ Easy Adjust Frequency.
', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan H501S X4 5.8G FPV Brushless With 1080P HD Camera GPS RC Quadcopter RTF', 69, 251.99, '220x220x70mm', '2700mAh', 20, 300, '- 5.8G FPV with 1080P HD camera are tuned amazingly to capture stunning pictures and videos from the sky.
- Built-in GPS(Universal version) positioning system, the accurate positioning location, perfect advanced follower.
- With Brushless motor.
- WIth Follow me function,headless mode,one key return.
- The intelligent battery with large capacity extends the flying time last to 20 minutes.
- Flying both indoor and outdoor.
', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 AIR H501A WIFI FPV Brushless With 1080P HD Camera GPS Waypoint RC Quadcopter RTF', 17, 368, '311x11x70mm', '2700mAh', 20, 300, '
Easy to control and more relaxtion and time to enjoy the flight experience.

Built in 1920x1080P HD camera are tuned amazingly to capture stunning pictures and videos from the sky.

Brushless motors provide better performance than their brushed counterparts. In addition, propeller attachment is self-tightening for additional security.

In this mode, based on readings from a barometer, the drone will maintain a fixed altitude. Horizontal movement, as well as rotation (yaw), will still be enabled.

In this mode, the drone will lock onto the position of the transmitter and track it. This is extremely beneficial when recording a moving subject that would be tricky to follow manually.

In this mode, there is no longer a defined "nose" and "tail." Instead, the aircraft always moves relative to the pilot â?? pressing forward moves forward, pressing left moves left, and so on. This keeps flying more intuitive, especially for beginner pilots.

With GPS-backed navigation system, the drone is able to remember its "home," or take off, point. If connection is lost with the transmitter, Failsafe Mode will engage, causing the quadcopter to automatically return to the home point and land. You can also manually trigger Failsafe Mode via a switch on the transmitt
Your smart device screen allows you to monitor real-time video from the FPV camera and will display vital flight telemetry data to keep you apprised of what is happening in the air.

The 2700mAh capacity battery provides 20 minutes of satisfying flight on a sigle charge.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Eachine Lizard95 95mm F3 FPV Racer BNF 4 in 1 10A ESC OSD 5.8G 48CH 25MW/100MW VTX 600TVL Camera 3S', 44, 109.99, '11.5 x 11.5 x 6cm', '550mAh', 4, 150, '-Extremely light and more powerful 3S power makes the Lizard 95 like a beast
-STM32 F303MCU + BLHELI_S ESC make your Operating feel more stability and silky
- Adjustable Angle of Camera
- Adjustable VTX Power 25mw/100mw
- Jaw-dropping flight performance
- Betaflight support
-Acro mode / Air mode /Angle mode support
-Built-in OSD(Using F3 MCU controls OSD over SPI bus in DMA mode)
-OSD Configuration has been include in BETAFLIGHT GUI
-Radio Stick to control PID Tunes
-BLEHELI_S pass-through ready
- Telemetry RSSI Output ready(Frsky Version)', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('MJX B2W Bugs 2W WiFi FPV Brushless With 1080P HD Camera GPS RC Quadcopter RTF', 74, 198, '41x41x8cm', '1800mAh ', 17, 1000, '* Built in 1080P HD camera are tuned amazingly to capture stunning pictures and videos from the sky.
* With altitude hold mode function provides stable flight.
* With GPS auto positioning system, accurate positioning location, perfect advanced follower.
* With One key to return function makes it easily to find the way home.
* 2.4GHz Technology Adopted for Anti-Interference.
* 4 Channel which can do ascend, descend, forward, backward, left sideward fly, right sideward fly and rolling 360Â°.
* 6-axis gyro which can have more stable flying and be easy to control.
* With LED lights making the flight more spectacular especially in the dark.', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 Pro H109S 5.8G FPV With 1080P HD Camera 3 Axis Gimbal GPS RC Quadcopter', 53, 786, '30x30x20cm', '5000mAh', 23, 1500, '* With headless mode function,no need to adjust the position of aircraft before flying ..
* With one key return function, makes it easily to find the way home.
* Built in 1080P HD camera are tuned amazingly to capture stunning pictures and videos from the sky.
* With GPS auto positioning system, accurate positioning location, perfect advanced follower.
* Gopro camera compatible with live video out to TX(gopro not included). Hubsan 1080P HD Camera included.
* Precise Aerodynamic light weight Design.
* Super strong PC plastic material body design
* 5.8Ghz live video without latency,(5.8Ghz VTX integrated design)
* Customer preference setting adjustable on TX
* Multifunctional landing gear
* Extended 2CH for your own DIY
* 1/3 Axis Camera Gimbal included.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 STAR H507A App Compatible Wifi FPV With 720P HD Camera GPS RC Quadcopter RTF', 87, 89.99, '22x22x6cm', '450mAh', 9, 300, 'The drone will lock onto the position of the transmitter and track it. This is extremely beneficial when recording a moving subject that would be tricky to follow manually.

With headless mode function,no need to adjust the position of aircraft before flying.

With GPS-backed navigation system, the drone is able to remember its "home," or takeoff, point. If connection is lost with the transmitter, Failsafe Mode will engage, causing the quadcopter to automatically return to the home point and land. You can also manually trigger Failsafe Mode via a switch on the transmitter.

Easy to control and more relaxtion and time to enjoy the flight experience.

The 550mAh capacity battery provides 20 minutes of satisfying flight on a sigle charge.', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('SYMA X5UW 720P WIFI FPV With 2MP HD Camera With Altitude Mode RC Quadcopter RTF', 80, 51, '32x32x7cm', '500mAh', 7, 40, '3D rollover,Automatic Return,Camera,Emergency Landing,Forward/backward,FPV,Headless Mode,One Key Automatic Return,One Key Landing,One Key Taking Off,Sideward flight,Turn left/right,Up/down,WiFi Connection,With Altitude Mode ', 1, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Syma X5HC With 2MP HD Camera 2.4G 4CH 6Axis Altitude Mode RC Quadcopter RTF', 77, 49.99, '33x33x11cm', '600mAh', 6, 40, 'With 2.0MP HD camera.
With high hold mode can set hight.
Headless mode,360 roll.
6-Axis gyro quad-rotorcraft flight, strong stability,can easily implement various flight movements, stronger wind resistance, easier to control.
The quadcopter can fly both indoor and outdoor.Including 4CH digital proportional RC system.
Rechargeable high performance battery.
Function:up/down,left/right sideward fight,forward/backward,turn left/right,with gyro/flash lights,A 360-degree 3D and special functions(continuous rolling)
', 2, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 STAR H507A App Compatible Wifi FPV With 720P HD Camera GPS RC Quadcopter RTF', 15, 91, '225x225x60mm', ' 450mAh', 10, 100, '720P HD Camera
Built in 720P HD camera are tuned amazingly to capture stunning pictures and videos from the sky.

Built-in GPS(Universal version) positioning system, the accurate positioning location, perfect advanced follower.

Based on readings from a barometer, the drone will maintain a fixed altitude. Horizontal movement, as well as rotation (yaw), will still be enabled.

Follow Me Mode
The drone will lock onto the position of the transmitter and track it. This is extremely beneficial when recording a moving subject that would be tricky to follow manually.

With headless mode function,no need to adjust the position of aircraft before flying.

With GPS-backed navigation system, the drone is able to remember its "home," or takeoff, point. If connection is lost with the transmitter, Failsafe Mode will engage, causing the quadcopter to automatically return to the home point and land. You can also manually trigger Failsafe Mode via a switch on the transmitter.

Easy to control and more relaxtion and time to enjoy the flight experience.

The 550mAh capacity battery provides 20 minutes of satisfying flight on a sigle charge.', 2, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('JJRC H26WH WIFI FPV With 2.0MP HD Camera Altitude Hold RC Quadcopter RTF', 37, 86, '60 x 60 x 17cm', '1200mAh', 10, 150, 'With WIFI FPV 2.0MP HD Camera.
With High Hold mode can set height.
Wifi real-time transmission FPV system which can capture photos and record videos for your great memory.
With attractive headless mode, completely solving pilot loss-of-orientation problem.
One key return function makes it easily to find the way home.
4 Channel which can do ascend, descend, forward, backward, left sideward fly, right sideward fly and rolling 360Â°
It has 6-axis gyro which can have more stable flying and be easy to control.
2.4G technology adopted for anti-interference, even more than one quadcopter is flying at the same time they will not interfere with each other.
Function: ascend / descend / forward / backward / side flying / 360Â°rolling action / LED / Camera / CF mode / One key return
', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('JJRC H26WH WIFI FPV With 2.0MP HD Camera Altitude Hold RC Quadcopter RTF', 37, 86, '60 x 60 x 17cm', '1200mAh', 10, 150, 'With WIFI FPV 2.0MP HD Camera.
With High Hold mode can set height.
Wifi real-time transmission FPV system which can capture photos and record videos for your great memory.
With attractive headless mode, completely solving pilot loss-of-orientation problem.
One key return function makes it easily to find the way home.
4 Channel which can do ascend, descend, forward, backward, left sideward fly, right sideward fly and rolling 360Â°
It has 6-axis gyro which can have more stable flying and be easy to control.
2.4G technology adopted for anti-interference, even more than one quadcopter is flying at the same time they will not interfere with each other.
Function: ascend / descend / forward / backward / side flying / 360Â°rolling action / LED / Camera / CF mode / One key return
', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 AIR H501A WIFI FPV Brushless With 1080P HD Camera GPS Waypoint RC Quadcopter RTF', 15, 368, '311x11x70mm', '2700mAh', 20, 300, '
Easy to control and more relaxtion and time to enjoy the flight experience.

Built in 1920x1080P HD camera are tuned amazingly to capture stunning pictures and videos from the sky.

Brushless motors provide better performance than their brushed counterparts. In addition, propeller attachment is self-tightening for additional security.

In this mode, based on readings from a barometer, the drone will maintain a fixed altitude. Horizontal movement, as well as rotation (yaw), will still be enabled.

In this mode, the drone will lock onto the position of the transmitter and track it. This is extremely beneficial when recording a moving subject that would be tricky to follow manually.

In this mode, there is no longer a defined "nose" and "tail." Instead, the aircraft always moves relative to the pilot â?? pressing forward moves forward, pressing left moves left, and so on. This keeps flying more intuitive, especially for beginner pilots.

With GPS-backed navigation system, the drone is able to remember its "home," or take off, point. If connection is lost with the transmitter, Failsafe Mode will engage, causing the quadcopter to automatically return to the home point and land. You can also manually trigger Failsafe Mode via a switch on the transmitt
Your smart device screen allows you to monitor real-time video from the FPV camera and will display vital flight telemetry data to keep you apprised of what is happening in the air.

The 2700mAh capacity battery provides 20 minutes of satisfying flight on a sigle charge.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 Pro H109S 5.8G FPV With 1080P HD Camera 3 Axis Gimbal GPS RC Quadcopter', 49, 786, '30x30x20cm', '5000mAh', 23, 1500, '* With headless mode function,no need to adjust the position of aircraft before flying ..
* With one key return function, makes it easily to find the way home.
* Built in 1080P HD camera are tuned amazingly to capture stunning pictures and videos from the sky.
* With GPS auto positioning system, accurate positioning location, perfect advanced follower.
* Gopro camera compatible with live video out to TX(gopro not included). Hubsan 1080P HD Camera included.
* Precise Aerodynamic light weight Design.
* Super strong PC plastic material body design
* 5.8Ghz live video without latency,(5.8Ghz VTX integrated design)
* Customer preference setting adjustable on TX
* Multifunctional landing gear
* Extended 2CH for your own DIY
* 1/3 Axis Camera Gimbal included.', 3, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT (NAME, COUNT, COST, SIZE, BATTERY, FLY_TIME, DISTANCE, DESCRIPTION, CATEGORY_ID, VISIBLE) VALUES ('Hubsan X4 STAR H507A App Compatible Wifi FPV With 720P HD Camera GPS RC Quadcopter RTF', 43, 101, '22x22x6cm', '450mAh', 9, 100, '720P HD Camera
Built in 720P HD camera are tuned amazingly to capture stunning pictures and videos from the sky.

Built-in GPS(Universal version) positioning system, the accurate positioning location, perfect advanced follower.

Based on readings from a barometer, the drone will maintain a fixed altitude. Horizontal movement, as well as rotation (yaw), will still be enabled.

The drone will lock onto the position of the transmitter and track it. This is extremely beneficial when recording a moving subject that would be tricky to follow manually.

With headless mode function,no need to adjust the position of aircraft before flying.

With GPS-backed navigation system, the drone is able to remember its "home," or takeoff, point. If connection is lost with the transmitter, Failsafe Mode will engage, causing the quadcopter to automatically return to the home point and land. You can also manually trigger Failsafe Mode via a switch on the transmitter.

Easy to control and more relaxtion and time to enjoy the flight experience.

The 550mAh capacity battery provides 20 minutes of satisfying flight on a sigle charge.', 2, 1);


INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('2016107016256123gql0k.jpg', 1);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('201707290105481iu25qdb.jpg', 2);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('50390_0.jpg', 3);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('Newest-Mini-Syma-font-b-X20-b-font-font-b-rc-b-font-font-b-helicopter.jpg', 4);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('db72c5c3-6895-43dc-9940-6141a284816c.jpg', 5);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('2016107011233317igykv8.jpg', 6);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('2016107011233317igykv8.jpg', 7);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('82c6d61f-ac14-4e76-a00e-7c6f7e13d724.jpg', 8);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('48f5fbb1-461d-4057-8763-75bc41957669.jpg', 9);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('48f5fbb1-461d-4057-8763-75bc41957669.jpg', 10);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('9db2fd8c-35f4-4715-90d6-10b8020c7ccd.jpg', 11);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('e0cefc71b70a3ca3f9469442e7408c37.jpg', 12);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('201603240182081u7i9pyv.jpg', 13);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('-In-Stock-font-b-Hubsan-b-font-font-b-X4-b-font-AIR-H501A-H906A.jpg', 14);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('e87e5212-0003-4339-910b-93e5f6c20b8a.jpg', 15);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('71d385b6-ad8a-4cb4-8fcb-85f3d08c12bf.jpg', 16);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('hubsan-x4-pro-h109s.jpg', 17);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('0E2668A97514E91C2446A4DAAA94C5FF.jpg', 18);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('0E2668A97514E91C2446A4DAAA94C5FF.jpg', 19);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('0E2668A97514E91C2446A4DAAA94C5FF.jpg', 20);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('Hubsan-X4-STAR-H507A-App-Compatible-Wifi-FPV-RC-Drones-With-720P-HD-Camera-GPS-Follow.jpeg_640x640.jpeg', 21);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('2016107016256123gql0k.jpg', 22);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('RM5073W-1-03ac-r8N6.jpg', 23);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('Hubsan-H502T-X4-Star-GPS-RC-Quadcopter-RTF-White-427884-.jpg', 24);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('9db2fd8c-35f4-4715-90d6-10b8020c7ccd.jpg', 25);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('9db2fd8c-35f4-4715-90d6-10b8020c7ccd.jpg', 26);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('-In-Stock-font-b-Hubsan-b-font-font-b-X4-b-font-AIR-H501A-H906A.jpg', 27);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('61Uzn2bwmlL._SX342_.jpg', 28);
INSERT INTO MYSHOP_SCHEMA.PICTURE (NAME, PRODUCT_ID) VALUES ('hubsan-x4-pro-h109s.jpg', 29);

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
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (6, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (6, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (6, 14);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (6, 11);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (6, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (6, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (6, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 14);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 11);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 16);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 11);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 18);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (7, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (8, 18);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (8, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (9, 19);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (9, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (9, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (9, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (9, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (10, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (10, 13);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (10, 12);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (10, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (10, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (10, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (11, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (11, 13);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (11, 12);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (11, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (11, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (11, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (12, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (12, 13);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (12, 12);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (12, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (12, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (12, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (13, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (13, 20);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (13, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (13, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (13, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (13, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (13, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (14, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (14, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (14, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (14, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (14, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (14, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (14, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (15, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (15, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (15, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (15, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (15, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (15, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (15, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (16, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (16, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (16, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (16, 21);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (17, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (17, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (17, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (17, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (17, 22);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (18, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (18, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (18, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (18, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (18, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (18, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (18, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (19, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (19, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (19, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (19, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (20, 13);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (20, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (20, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (21, 13);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (21, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (21, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (22, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (22, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (22, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (22, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (23, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (23, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (23, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (24, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (24, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (24, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (24, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (24, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (24, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (24, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (25, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (25, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (25, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (25, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (25, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (25, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (25, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (26, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (26, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (26, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (26, 21);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (27, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (27, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (27, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (27, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (27, 22);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (28, 1);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (28, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (28, 4);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (28, 2);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (28, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (28, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (28, 3);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (29, 15);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (29, 5);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (29, 10);
INSERT INTO MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY (PRODUCT_ID, PROPERTY_ID) VALUES (29, 3);

INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (2, 2, 1, 2, 1, '2017-08-07 01:20:09');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (3, 1, 2, 4, 2, '2017-08-07 01:24:50');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (3, 1, 1, 4, 1, '2017-08-07 01:25:06');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (3, 1, 2, 4, 3, '2017-08-07 01:25:33');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (4, 3, 1, 4, 2, '2017-08-07 01:26:35');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (13, 53, 1, 1, 3, '2017-09-10 16:30:40');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (14, 54, 1, 1, 3, '2017-09-10 16:42:53');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (15, 55, 1, 1, 1, '2017-09-10 16:51:09');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (16, 56, 1, 1, 1, '2017-09-10 16:58:07');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (16, 56, 1, 1, 1, '2017-09-10 16:58:08');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (16, 56, 1, 1, 1, '2017-09-10 16:58:12');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (16, 56, 1, 1, 1, '2017-09-10 16:58:14');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (13, 53, 1, 1, 3, '2017-09-10 17:00:43');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (13, 53, 1, 1, 3, '2017-09-10 17:00:49');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (13, 53, 1, 1, 3, '2017-09-10 17:00:50');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (13, 53, 1, 1, 3, '2017-09-10 17:00:52');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (17, 58, 1, 1, 1, '2017-09-10 17:05:38');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (17, 58, 1, 1, 1, '2017-09-10 17:06:12');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (17, 58, 1, 1, 1, '2017-09-10 17:07:09');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (3, 59, 1, 1, 1, '2017-09-10 17:09:11');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (18, 60, 1, 1, 1, '2017-09-10 17:13:23');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (18, 60, 1, 1, 1, '2017-09-10 17:14:33');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (18, 60, 1, 1, 1, '2017-09-10 17:15:10');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (18, 60, 1, 1, 1, '2017-09-10 17:15:54');
INSERT INTO MYSHOP_SCHEMA.ORDERS (USER_ID, USER_ADDRESS_ID, PAY_WAY_ID, DELIVERY_STATUS_ID, DELIVERY_WAY_ID, TIME) VALUES (19, 61, 1, 1, 3, '2017-09-10 17:23:35');


INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 2, 1, 18.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (3, 1, 1, 85.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (1, 1, 2, 62.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 2, 18.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 2, 19.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (5, 1, 2, 159.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 3, 18.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (1, 1, 4, 62.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 4, 19.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (5, 1, 4, 159.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 5, 18.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (3, 1, 5, 85.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 5, 19.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (20, 1, 6, 91);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (3, 1, 7, 85.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (20, 1, 7, 91);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (24, 1, 7, 786);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 8, 38.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (7, 1, 8, 999);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (13, 1, 8, 368);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (24, 1, 8, 786);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 9, 38.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 9, 39.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (15, 1, 9, 101);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 10, 38.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 10, 39.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (25, 1, 10, 101);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 11, 38.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (3, 1, 11, 85.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 11, 39.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 12, 38.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (3, 1, 12, 85.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 12, 39.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 1, 13, 38.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (3, 1, 13, 85.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 13, 39.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (1, 1, 14, 62.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 1, 14, 39.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (14, 1, 15, 786);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (13, 1, 16, 368);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (5, 1, 17, 159.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (10, 1, 17, 368);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (11, 1, 17, 786);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (12, 1, 17, 101);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (7, 5, 17, 999);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (6, 1, 18, 999);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (10, 1, 18, 368);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (11, 1, 18, 786);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (7, 10, 19, 999);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (7, 10, 20, 999);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (2, 3, 21, 38.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (4, 5, 21, 39.99);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (10, 1, 21, 91);
INSERT INTO MYSHOP_SCHEMA.BUCKET (PRODUCT_ID, COUNT_PRODUCT, ORDER_ID, COST_PRODUCT) VALUES (25, 5, 21, 101);








