package com.epam.rd.tasks.sqlqueries;

/**
 * Implement sql queries like described
 */
public class SqlQueries {
    //Select all employees sorted by last name in ascending order
    //language=HSQLDB
    String select01 = "SELECT * from employee order by lastname";

    //Select employees having no more than 5 characters in last name sorted by last name in ascending order
    //language=HSQLDB
    String select02 = "SELECT * FROM employee where length(lastname) <= 5 order by lastname";

    //Select employees having salary no less than 2000 and no more than 3000
    //language=HSQLDB
    String select03 = "SELECT * from employee where salary between 2000 and 3000 ";

    //Select employees having salary no more than 2000 or no less than 3000
    //language=HSQLDB
    String select04 = "SELECT * from employee where salary not between 2000 and 2999 ";

    //Select all employees assigned to departments and corresponding department
    //language=HSQLDB
    String select05 = "SELECT lastname, salary, name FROM employee e, department d" +
            "  WHERE e.department = d.id ";

    //Select all employees and corresponding department name if there is one.
    //Name column containing name of the department "depname".
    //language=HSQLDB
    String select06 =  "SELECT lastname, salary, name AS depname " +
            "FROM employee e LEFT JOIN  department d " +
            "ON e.department = d.id";

    //Select total salary pf all employees. Name it "total".
    //language=HSQLDB
    String select07 = "SELECT sum(salary) AS total FROM employee ";

    //Select all departments and amount of employees assigned per department
    //Name column containing name of the department "depname".
    //Name column containing employee amount "staff_size".
    //language=HSQLDB
    String select08 = "SELECT name AS depname, COUNT(*) AS staff_size" +
            " FROM department d , employee e WHERE e.department = d.id " +
            "group by d.id" ;

    //Select all departments and values of total and average salary per department
    //Name column containing name of the department "depname".
    //language=HSQLDB
    String select09 = "SELECT name depname, sum(salary) total, avg(salary) average " +
            "FROM department d, employee e WHERE  e.department = d.id " +
            "GROUP BY d.id";

    //Select lastnames of all employees and lastnames of their managers if an employee has a manager.
    //Name column containing employee's lastname "employee".
    //Name column containing manager's lastname "manager".
    //language=HSQLDB
    String select10 = "SELECT e.lastname AS employee, e2.lastname AS manager FROM employee e " +
            "JOIN employee e2 ON e2.id = e.manager";

//    String select10 = "SELECT e.lastname AS employee, e2.lastname AS manager FROM employee e, employee e2 " +
//            "where  e2.id = e.manager or e2.manager is null";
}
