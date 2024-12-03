 /*1. get second highest salary */
select max(sal) from emp where sal not in (select max(sal )from emp);
 // or //
 select max(sal) from emp where sal != (select max(sal )from emp);
 // or //
 select max(sal) from emp where sal < (select max(sal )from emp);

 /* display the highest paid salary in each department*/
 select max(sal),department from emp group by department;

 /*display alternate records*/
 select * from (select empno,rownum rn order by empno) where mod(rn,2)=0;
  
  /* display  frequency of each emplayee with same name but it should not be single*/
   select count(*),empnmae from emp group by empname having count(*)>1;

/* name starts with 'm'*/
select empname from emp where empname like "m%";

/* name ends with 'n'*/
select empname from emp where empname like '%n';

/* name having m at any positon */
select empname from emp where empname like "%m%";
 
/* name doesnt having m at any positon */
select empname from emp where empname not like "%m%";
 
/* name of 4 characters */
select empnmae from emp where empname like '____';

/* name of with 2nd letter as l and 4th letter as f;*/
select empnmae from emp where empname like '_l_f%';

/* display name of emp and hired dates who joined in the month of december;*/
select empnmae,hiredate from emp where hiredate like '%DEC%';

/*display nth row of the emp*/
select * from emp where rownum<=4 minus select * from emp where rownum<=3;
// or //
select * from (select rownum r, emp.* from emp ) where r=4;

/* display first row as well as last row */
select * from (select rownum r,emp.* from emp)where r=1 or r=(select count(*) from emp);

/*display first n rowns */
select * from emp LIMIT n;
// or //
select * from (select rownum r, emp.* from emp) where r<=n;


/* display 5 highest salary departmenet wise*/
SELECT Department, EmployeeName, Salary
FROM Employee AS e1
WHERE Salary IN (
    SELECT Salary
    FROM Employee AS e2
    WHERE e2.Department = e1.Department
    ORDER BY Salary DESC
    LIMIT 5
)
ORDER BY Department, Salary DESC;

/*display last n rows of the table */
 select * from emp minus select * from emp where rownum <=( select count(*)-n from emp);
 //or //
 select * from (select rownum r ,emp.* from emp) where r> (select count(* )-n from emp);

 /*display first n and last n rows */
 select * from (select rownum r ,emp.* from emp) where r<=n or r> (select count(*)-n from emp);

 /*display n highest salaray  - hint - derive the table of descinding order of
 salary using subquery annd retrive 
 n slaries*/
select * from ( select sal from emp order by sal desc) where rownum<=n;
// or //
select empname,salary from emp order by sal DESC LIMIT n; // limit supported by only mysql

/*display nth highest salary */
 select * from ( select sal from emp order by sal desc) where rownum<=n; 
 minus
 select * from ( select sal from emp order by sal desc) where rownum<=n-1;

 -----------------------joins------------
  /* display empllyee details whose salary are more than managers salary*/
  SELECT e1.name AS employee, e2.name AS manager
FROM emp e1
JOIN emp e2 ON e1.mgr = e2.empno
WHERE e1.sal > e2.sal;

   /* display employee details who joined before manager raju in the company */
    SELECT e1.name AS employee, e2.name AS manager
FROM emp e1
JOIN emp e2 ON e1.mgr = e2.empno
WHERE e2.name = 'raju'
  AND e1.hiredate < e2.hiredate;
  
  /*Display employees who are working in Location Chicago from emp and dept table:*/
  SELECT e.emp_name, e.emp_id, d.dept_name
FROM emp e
JOIN dept d ON e.dept_id = d.dept_id
WHERE d.location = 'Chicago';

/*Display the department name and total salaries from each department:*/
SELECT d.dept_name, SUM(e.salary) AS total_salaries
FROM emp e
JOIN dept d ON e.dept_id = d.dept_id
GROUP BY d.dept_name;

/*switch to another database, show all tables present in that,describe the structure of x table*/
use db;
show tables;
describe x;

/* display 20 records starting from  51th rowns*/
select * from emp limit 20 offset 50;

/* display all names where the department is either csse , ece */
select * from emp where departmenet in (ece, csse);

/*find the years where joined more than 1000 members */
select count(year),year from emp group by year having count(year)>1000;

/* join table without using ON*/
select * from emp e1 join emp e2 using e1.id=e2.id;

/*copy rows from tabel1 to table2 using subquery*/
insert into table2 (col1,col2) select col1,col2 from table2;

/* create a table with id as primary key, name should not contain null, email should be unique and their salary
should be more than 20000,ALSO create a timestamp to see when the row is inserted AND ALSO ADD
FOREIGHN KEY AS ID WHICH AS FOREIGN KEY AS DEPID IN DEPT TABLE*/
create TABLE tablename (id INT PRIMARY KEY, NAME VARCHAR(20) NOT NULL, EMAIL VARCHAR(100)UNIQUE, 
Salary DECIMAL(10,2) CHECK(Salary>20000),timeinserted timestamp DEFAULT CURRENT_TIMESTAMP,FOREIGN KEY(ID)
REFERENCES DEPT(DEPID));

/* CREATE INDEX ON COL NAME FOR FAST RETRUVAL */
CREATE INDEX IDX_USER ON EMP(NAME);

/*DO ALTER OPERATIONS */
ALTER TABLE EMP ADD sports VARCHAR(11);
ALTER TABLE EMP MODIFY sports INT;
ALTER TABLE EMP DROP sports;
ALTER TABLE table_name
RENAME COLUMN old_column_name TO new_column_name;

/* REMOVE ALL ROWS THEN DELETE TABLE FROM DB;*/
TRUNCATE TABLE EMP;
DROP TABLE EMP  IF EXISTS;