
CREATE TABLE contact (
   id bigint(20) NOT NULL,
   email varchar(255) NOT NULL,
   name varchar(255) NOT NULL,
   phone varchar(255) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE organisation (
    id bigint(20) NOT NULL,
    address varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    url varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE organisation_contact (
    organisation_id bigint(20) NOT NULL,
    contacts_id bigint(20) NOT NULL,
    PRIMARY KEY (organisation_id,contacts_id),
    KEY organisation_contact_pk (contacts_id),
    CONSTRAINT organisation_fk FOREIGN KEY (organisation_id) REFERENCES organisation (id),
    CONSTRAINT contact_fk FOREIGN KEY (contacts_id) REFERENCES contact (id)
);

