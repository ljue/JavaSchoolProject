create table myshop_schema.Address
(
	AddressId bigint auto_increment
		primary key,
	Country varchar(255) not null,
	Region varchar(255) not null,
	City varchar(255) not null,
	StreetAddress varchar(255) not null,
	PostIndex varchar(30) not null,
	UserId bigint null
)
;

create index Adress_City_id_fk
	on Address (City)
;

create index Adress_Country_id_fk
	on Address (Country)
;

create index Adress_Region_id_fk
	on Address (Region)
;

create index Address_User_Id_fk
	on Address (UserId)
;

create table myshop_schema.City
(
	id bigint auto_increment
		primary key,
	region_id bigint not null,
	name varchar(128) not null
)
;

create table myshop_schema.Country
(
	id bigint not null
		primary key,
	name varchar(128) not null
)
;

create table myshop_schema.DeliveryStatus
(
	DeliveryStatusId int auto_increment
		primary key,
	DeliveryStatusName varchar(30) not null,
	constraint PayStatusName
	unique (DeliveryStatusName)
)
;

create table myshop_schema.DeliveryWay
(
	DeliveryWayId int auto_increment
		primary key,
	DeliveryWayName varchar(50) not null,
	constraint DeliveryStatusName
	unique (DeliveryWayName)
)
;

create table myshop_schema.`Order`
(
	OrderId bigint auto_increment
		primary key,
	UserId bigint not null,
	UserAddress bigint not null,
	PayWay int not null,
	DeliveryStatus int not null,
	DeliveryWay int not null,
	DateTimeOrder timestamp default CURRENT_TIMESTAMP not null,
	constraint Order_Address_AddressId_fk
	foreign key (UserAddress) references myshop_schema.Address (AddressId),
	constraint Order_fk3
	foreign key (DeliveryStatus) references myshop_schema.DeliveryStatus (DeliveryStatusId),
	constraint Order_fk4
	foreign key (DeliveryWay) references myshop_schema.DeliveryWay (DeliveryWayId)
)
;

create index Order_fk0
	on `Order` (UserId)
;

create index Order_fk2
	on `Order` (PayWay)
;

create index Order_fk3
	on `Order` (DeliveryStatus)
;

create index Order_fk4
	on `Order` (DeliveryWay)
;

create index Order_Address_AddressId_fk
	on `Order` (UserAddress)
;

create table myshop_schema.Order_Product
(
	id bigint auto_increment
		primary key,
	OrderId bigint null,
	ProductId bigint null,
	constraint Order_Product_Order_OrderId_fk
	foreign key (OrderId) references myshop_schema.`Order` (OrderId)
)
;

create index Order_Product_Order_OrderId_fk
	on Order_Product (OrderId)
;

create index Order_Product_Product_ProductId_fk
	on Order_Product (ProductId)
;

create table myshop_schema.PayWay
(
	PayWayId int auto_increment
		primary key,
	PayWayName varchar(50) not null,
	constraint PayWayName
	unique (PayWayName)
)
;

alter table `Order`
	add constraint Order_fk2
foreign key (PayWay) references myshop_schema.PayWay (PayWayId)
;

create table myshop_schema.Pictures
(
	PictureId bigint auto_increment
		primary key,
	PicName varchar(255) null,
	ProductId bigint null
)
;

create index Pictures_Product_ProductId_fk
	on Pictures (ProductId)
;

create table myshop_schema.Prod_Prop
(
	ProductId bigint null,
	ProductPropertyId int null,
	prod_prop_id bigint auto_increment
		primary key,
	constraint Prod_Prop_prod_prop_id_uindex
	unique (prod_prop_id)
)
;

create index Prod_Prop_ProductProperty_ProdPropId_fk
	on Prod_Prop (ProductPropertyId)
;

create index Prod_Prop_Product_ProductId_fk
	on Prod_Prop (ProductId)
;

create table myshop_schema.Prod_RadioProp
(
	id bigint auto_increment
		primary key,
	ProductId bigint null,
	RadioPropId int null
)
;

create index Product_RadioProp_ProductRadioProperty_id_fk
	on Prod_RadioProp (RadioPropId)
;

create index Product_RadioProp_Product_ProductId_fk
	on Prod_RadioProp (ProductId)
;

create table myshop_schema.Product
(
	ProductId bigint auto_increment
		primary key,
	ProductName varchar(255) not null,
	Count int not null,
	Cost double not null,
	Size varchar(50) null,
	Battery varchar(50) null,
	FlyTime varchar(50) null,
	Distance varchar(50) null,
	Description varchar(500) null,
	Category int null
)
;

create index Product_ProductCategory_CategoryId_fk
	on Product (Category)
;

alter table Order_Product
	add constraint Order_Product_Product_ProductId_fk
foreign key (ProductId) references myshop_schema.Product (ProductId)
;

alter table Pictures
	add constraint Pictures_Product_ProductId_fk
foreign key (ProductId) references myshop_schema.Product (ProductId)
;

alter table Prod_Prop
	add constraint Prod_Prop_Product_ProductId_fk
foreign key (ProductId) references myshop_schema.Product (ProductId)
;

alter table Prod_RadioProp
	add constraint Product_RadioProp_Product_ProductId_fk
foreign key (ProductId) references myshop_schema.Product (ProductId)
;

create table myshop_schema.ProductCategory
(
	CategoryId int auto_increment
		primary key,
	CategoryName varchar(50) null,
	constraint ProductCategory_CategoryName_uindex
	unique (CategoryName)
)
;

alter table Product
	add constraint Product_ProductCategory_CategoryId_fk
foreign key (Category) references myshop_schema.ProductCategory (CategoryId)
;

create table myshop_schema.ProductProperty
(
	ProdPropId int auto_increment
		primary key,
	ProdPropCatId int null,
	ProdPropName varchar(255) null
)
;

create index ProductProperty_PropertyCategory_PropCatId_fk
	on ProductProperty (ProdPropCatId)
;

alter table Prod_Prop
	add constraint Prod_Prop_ProductProperty_ProdPropId_fk
foreign key (ProductPropertyId) references myshop_schema.ProductProperty (ProdPropId)
;

create table myshop_schema.ProductRadioProperty
(
	id int auto_increment
		primary key,
	name varchar(255) null,
	radioCategoryId int null
)
;

create index ProductRadioProperty_PropertyRadioCategory_id_fk
	on ProductRadioProperty (radioCategoryId)
;

alter table Prod_RadioProp
	add constraint Product_RadioProp_ProductRadioProperty_id_fk
foreign key (RadioPropId) references myshop_schema.ProductRadioProperty (id)
;

create table myshop_schema.PropertyCategory
(
	PropCatId int not null
		primary key,
	PropCatName varchar(255) null
)
;

alter table ProductProperty
	add constraint ProductProperty_PropertyCategory_PropCatId_fk
foreign key (ProdPropCatId) references myshop_schema.PropertyCategory (PropCatId)
;

create table myshop_schema.PropertyRadioCategory
(
	id int auto_increment
		primary key,
	name varchar(255) null
)
;

alter table ProductRadioProperty
	add constraint ProductRadioProperty_PropertyRadioCategory_id_fk
foreign key (radioCategoryId) references myshop_schema.PropertyRadioCategory (id)
;

create table myshop_schema.Region
(
	id bigint not null
		primary key,
	country_id bigint not null,
	name varchar(128) not null
)
;

create table myshop_schema.Role
(
	IdRole bigint not null
		primary key,
	name varchar(20) null,
	constraint Role_name_uindex
	unique (name)
)
;

create table myshop_schema.User
(
	Id bigint auto_increment
		primary key,
	login varchar(30) not null,
	pass varchar(30) not null,
	email varchar(30) null,
	FirstName varchar(30) null,
	SecondName varchar(30) null,
	Birthday date null,
	Role bigint not null,
	constraint login
	unique (login),
	constraint email
	unique (email),
	constraint User_Role_IdRole_fk
	foreign key (Role) references myshop_schema.Role (IdRole)
)
;

create index User_Role_IdRole_fk
	on User (Role)
;

alter table Address
	add constraint Address_User_Id_fk
foreign key (UserId) references myshop_schema.User (Id)
;

alter table `Order`
	add constraint Order_fk0
foreign key (UserId) references myshop_schema.User (Id)
;

