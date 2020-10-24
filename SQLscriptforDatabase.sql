use emis;

credentialCREATE TABLE credential(
	id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    login_date DATE,
    status BOOLEAN,
    PRIMARY KEY(id)
    );
    
INSERT INTO credential(email,password,login_date,status)
VALUES ('admin','admin','2020-10-18',true)

INSERT INTO credential(email,password,login_date,status)
VALUES ('praswish@gmail.com','maharjan','2020-10-18',true)

INSERT INTO credential(email,password,login_date,status)
VALUES ('test','test','2020-10-18',true)