-- change this to your team id
use ftp88;

-- comment this line for the very first time
drop table if exists EMPLOYEE_DETAILS;

-- create the table

CREATE TABLE EMPLOYEE_DETAILS
(
	EMP_ID INT PRIMARY KEY,
    EMP_FULLNAME VARCHAR(30),
    EMP_EMAILID VARCHAR(30),
    EMP_MOBILENO VARCHAR(30),
    EMP_JOINDATE DATE,
    EMP_DEPT VARCHAR(30),
    EMP_ELBAL INT,
	EMP_MLBAL INT,
	EMP_SLBAL INT,
    EMP_MGRID INT,
    FOREIGN KEY(EMP_MGRID) REFERENCES EMPLOYEE_DETAILS(EMP_ID)
)


drop table if exists LEAVE_DETAILS;

-- create the table

CREATE TABLE LEAVE_DETAILS
(   LEA_EMPID INT,
	LEA_ID INT PRIMARY KEY AUTO_INCREMENT,
	LEA_STARTDATE DATE,
    LEA_ENDDATE DATE,
    LEA_NO_OF_DAYS INT,
    LEA_TYPE ENUM ('EL','ML','SL'),
    LEA_STATUS ENUM('PENDING','APPROVED','DENIED'),
    LEA_REASONS VARCHAR(30),
    LEA_APPLIEDON DATE,
    LEA_MGRCOMMENT VARCHAR(30),
    FOREIGN KEY(LEA_EMPID) REFERENCES EMPLOYEE_DETAILS(EMP_ID)
);