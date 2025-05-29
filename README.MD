# Software Development Tutorials

## Proposal

- Understanding what Git is
- How to use Git
- Providing technical support for application development.

```sql
create database practicaDesarrollo;

use practicaDesarrollo;

create table personas(
	ID int primary key identity(1,1),
	Nombre varchar(50) not null, 
	Edad int check (Edad >= 0 and Edad <= 120)
)
```