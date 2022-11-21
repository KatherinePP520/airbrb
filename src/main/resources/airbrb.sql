Use Airbrb;

DROP TABLE Users;

Create table Users(
     id         integer NOT NULL AUTO_INCREMENT,
     name       varchar(64)  NOT NULL,
     email      varchar(256)  NOT NULL,
     password   varchar(64)  NOT NULL,
     primary key (id)
);

Use Airbrb;
DROP TABLE Address;
DROP TABLE Amenities;
DROP TABLE Reviews;
DROP TABLE Availabilities;
DROP TABLE Metadata;
DROP TABLE Listings;

# DELETE FROM Address;
# DELETE FROM Listings;

select * from Listings as l inner join Address as a On l.id = a.id

CREATE TABLE Listings (
     id         integer NOT NULL AUTO_INCREMENT,
     title      varchar(256)  NOT NULL,
     owner      integer NOT NULL,
     price      float4 NOT NULL,
    thumbnail   LONGBLOB NOT NULL,
    postedOn TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    published BOOLEAN NOT NULL DEFAULT false,
    primary key(id),
    foreign key (owner) REFERENCES Users(id)
);

CREATE TABLE Address(
    id   integer NOT NULL,
    street varchar(256)  NOT NULL,
    city   varchar(64)  NOT NULL,
    state   varchar(32)  NOT NULL,
    postcode integer NOT NULL,
    country  varchar(64)  NOT NULL,
    primary key(id),
    foreign key (id) References Listings(id)
);

CREATE TABLE Metadata(
    id   integer NOT NULL AUTO_INCREMENT,
    listingId   integer NOT NULL,
    propertyType varchar(16)  NOT NULL,
    numOfBeds integer NOT NULL,
    numOfBedrooms integer NOT NULL,
    numOfBathrooms integer NOT NULL,
    primary key(id, listingId),
    foreign key (listingId) References Listings(id)
);

CREATE TABLE Amenities(
    metadataId   integer NOT NULL,
    listingId   integer NOT NULL,
    amenity varchar(32)  NOT NULL,
    primary key(metadataId, listingId),
    foreign key (listingId) References Listings(id),
    foreign key (metadataId) References Metadata(id)
);

CREATE TABLE Reviews(
      id   integer NOT NULL AUTO_INCREMENT,
      listingId   integer NOT NULL,
      userId  integer NOT NULL,
      review  varchar(1024)  NOT NULL,
      rating  integer NOT NULL,
      primary key(id, listingId,userId),
      foreign key (listingId) References Listings(id),
      foreign key (userId) References Users(id)
);

CREATE TABLE Availabilities(
    id   integer NOT NULL AUTO_INCREMENT,
    listingId   integer NOT NULL,
    startDate  varchar(16)  NOT NULL,
    endDate  varchar(16)  NOT NULL,
    primary key(id,listingId),
    foreign key (listingId) References Listings(id)
);
