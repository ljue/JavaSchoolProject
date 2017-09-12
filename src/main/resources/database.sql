create table MYSHOP_SCHEMA.ADDRESS
(
	ADDRESS_ID bigint auto_increment
		primary key,
	COUNTRY varchar(255) not null,
	REGION varchar(255) not null,
	CITY varchar(255) not null,
	STREET_ADDRESS varchar(255) not null,
	POST_INDEX varchar(30) not null,
	USER_ID bigint null,
	VISIBLE tinyint(1) default '1' not null
)
;

create index ADDRESS_USER_ID_FK
	on ADDRESS (USER_ID)
;

create table MYSHOP_SCHEMA.BUCKET
(
	BUCKET_ID int auto_increment
		primary key,
	PRODUCT_ID bigint null,
	COUNT_PRODUCT int null,
	ORDER_ID bigint null,
	COST_PRODUCT double null,
	constraint BUCKET_ID_uindex
		unique (BUCKET_ID)
)
;

create table MYSHOP_SCHEMA.CATEGORY
(
	CATEGORY_ID bigint auto_increment
		primary key,
	NAME varchar(50) null,
	VISIBLE tinyint(1) default '1' not null,
	constraint CATEGORY_NAME_UINDEX
		unique (NAME)
)
;

create table MYSHOP_SCHEMA.DELIVERY_STATUS
(
	DELIVERY_STATUS_ID bigint auto_increment
		primary key,
	NAME varchar(30) not null,
	constraint DELIVERY_STATUS_DELIVERY_STATUS_ID_uindex
		unique (DELIVERY_STATUS_ID)
)
;

create table MYSHOP_SCHEMA.DELIVERY_WAY
(
	DELIVERY_WAY_ID bigint auto_increment
		primary key,
	NAME varchar(50) not null,
	constraint DELIVERY_WAY_DELIVERY_WAY_ID_uindex
		unique (DELIVERY_WAY_ID),
	constraint DELIVERY_STATUSNAME
		unique (NAME)
)
;

create table MYSHOP_SCHEMA.ORDERS
(
	ORDER_ID bigint auto_increment
		primary key,
	USER_ID bigint not null,
	USER_ADDRESS_ID bigint not null,
	PAY_WAY_ID bigint not null,
	DELIVERY_STATUS_ID bigint null,
	DELIVERY_WAY_ID bigint not null,
	TIME timestamp default CURRENT_TIMESTAMP not null,
	constraint ORDER_ADDRESS_ID_FK
		foreign key (USER_ADDRESS_ID) references MYSHOP_SCHEMA.ADDRESS (ADDRESS_ID),
	constraint ORDER_FK3
		foreign key (DELIVERY_STATUS_ID) references MYSHOP_SCHEMA.DELIVERY_STATUS (DELIVERY_STATUS_ID),
	constraint ORDER_FK4
		foreign key (DELIVERY_WAY_ID) references MYSHOP_SCHEMA.DELIVERY_WAY (DELIVERY_WAY_ID)
)
;

create index ORDER_ADDRESS_ID_FK
	on ORDERS (USER_ADDRESS_ID)
;

create index ORDER_FK0
	on ORDERS (USER_ID)
;

create index ORDER_FK2
	on ORDERS (PAY_WAY_ID)
;

create index ORDER_FK3
	on ORDERS (DELIVERY_STATUS_ID)
;

create index ORDER_FK4
	on ORDERS (DELIVERY_WAY_ID)
;

create table MYSHOP_SCHEMA.PAY_WAY
(
	PAY_WAY_ID bigint auto_increment
		primary key,
	NAME varchar(50) not null,
	constraint UC_NAME
		unique (NAME)
)
;

alter table MYSHOP_SCHEMA.ORDERS
	add constraint ORDER_FK2
		foreign key (PAY_WAY_ID) references MYSHOP_SCHEMA.PAY_WAY (PAY_WAY_ID)
;

create table MYSHOP_SCHEMA.PICTURE
(
	PICTURE_ID bigint auto_increment
		primary key,
	NAME varchar(255) null,
	PRODUCT_ID bigint null
)
;

create index PICTURE_PRODUCT_ID_FK
	on PICTURE (PRODUCT_ID)
;

create table MYSHOP_SCHEMA.PRODUCT
(
	PRODUCT_ID bigint auto_increment
		primary key,
	NAME varchar(255) not null,
	COUNT int not null,
	COST double not null,
	SIZE varchar(50) null,
	BATTERY varchar(50) null,
	FLY_TIME int null,
	DISTANCE int null,
	DESCRIPTION varchar(2000) null,
	CATEGORY_ID bigint null,
	VISIBLE tinyint(1) default '1' not null,
	constraint PRODUCT_CATEGORY_ID_FK
		foreign key (CATEGORY_ID) references MYSHOP_SCHEMA.CATEGORY (CATEGORY_ID)
)
;

create index PRODUCT_CATEGORY_ID_FK
	on PRODUCT (CATEGORY_ID)
;

create table MYSHOP_SCHEMA.PRODUCT_HAS_PROPERTY
(
	PRODUCT_ID bigint null,
	PROPERTY_ID bigint null,
	PRODUCT_HAS_PROPERTY_ID bigint auto_increment
		primary key,
	constraint PRODUCT_HAS_PROPERTY_PRODUCT_HAS_PROPERTY_ID_uindex
		unique (PRODUCT_HAS_PROPERTY_ID),
	constraint PRODUCT_HAS_PROPERTY_PRODUCT_PRODUCT_ID_fk
		foreign key (PRODUCT_ID) references MYSHOP_SCHEMA.PRODUCT (PRODUCT_ID)
)
;

create index PRODUCT_HAS_PROPERTY_PRODUCT_PRODUCT_ID_fk
	on PRODUCT_HAS_PROPERTY (PRODUCT_ID)
;

create index PRODUCT_HAS_PROPERTY_PROPERTY_PROPERTY_ID_fk
	on PRODUCT_HAS_PROPERTY (PROPERTY_ID)
;

create table MYSHOP_SCHEMA.PROPERTY
(
	PROPERTY_ID bigint auto_increment
		primary key,
	PROPERTY_GROUP_ID bigint null,
	NAME varchar(255) null,
	VISIBLE tinyint(1) default '1' not null
)
;

create index PROPERTY_PROPERTY_GROUP_PROPERTY_GROUP_ID_fk
	on PROPERTY (PROPERTY_GROUP_ID)
;

alter table PRODUCT_HAS_PROPERTY
	add constraint PRODUCT_HAS_PROPERTY_PROPERTY_PROPERTY_ID_fk
		foreign key (PROPERTY_ID) references MYSHOP_SCHEMA.PROPERTY (PROPERTY_ID)
;

create table MYSHOP_SCHEMA.PROPERTY_GROUP
(
	PROPERTY_GROUP_ID bigint auto_increment
		primary key,
	NAME varchar(255) null,
	SOLO tinyint(1) null,
	VISIBLE tinyint(1) default '1' not null
)
;

alter table MYSHOP_SCHEMA.PROPERTY
	add constraint PROPERTY_PROPERTY_GROUP_PROPERTY_GROUP_ID_fk
		foreign key (PROPERTY_GROUP_ID) references MYSHOP_SCHEMA.PROPERTY_GROUP (PROPERTY_GROUP_ID)
;

create table MYSHOP_SCHEMA.ROLE
(
	ROLE_ID bigint not null
		primary key,
	NAME varchar(20) null,
	constraint ROLE_NAME_UINDEX
		unique (NAME)
)
;

create table MYSHOP_SCHEMA.USER
(
	USER_ID bigint auto_increment
		primary key,
	LOGIN varchar(30) not null,
	PASSWORD varchar(30) not null,
	EMAIL varchar(30) null,
	FIRST_NAME varchar(30) null,
	LAST_NAME varchar(30) null,
	BIRTHDAY date null,
	ROLE_ID bigint not null,
	constraint login
		unique (LOGIN),
	constraint email
		unique (EMAIL),
	constraint USER_ROLE_IDROLE_FK
		foreign key (ROLE_ID) references MYSHOP_SCHEMA.ROLE (ROLE_ID)
)
;

create index USER_ROLE_IDROLE_FK
	on USER (ROLE_ID)
;

alter table MYSHOP_SCHEMA.ADDRESS
	add constraint ADDRESS_USER_ID_FK
		foreign key (USER_ID) references MYSHOP_SCHEMA.USER (USER_ID)
;

alter table MYSHOP_SCHEMA.ORDERS
	add constraint ORDER_FK0
		foreign key (USER_ID) references MYSHOP_SCHEMA.USER (USER_ID)
;

