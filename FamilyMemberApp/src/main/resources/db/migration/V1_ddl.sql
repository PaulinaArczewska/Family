CREATE TABLE FamilyMemberDB(
id INT NOT NULL AS PRIMARY KEY,
familyId INT NOT NULL,
givenName VARCHAR(50)  NOT NULL,
familyName VARCHAR(50)  NOT NULL,
age INT NOT NULL
);