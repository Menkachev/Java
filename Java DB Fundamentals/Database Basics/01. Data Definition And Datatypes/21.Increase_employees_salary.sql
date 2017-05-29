UPDATE employees
SET employees.salary=employees.salary + (employees.salary * 0.10);

SELECT salary FROM employees;