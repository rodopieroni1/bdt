USE challenge;

CREATE TABLE TBL_gerencias (
  id INTEGER PRIMARY KEY,
  gerencia TEXT NOT NULL,
  ciudad TEXT NOT NULL
);

CREATE TABLE TBL_nivel_educacion   (
  id INTEGER PRIMARY KEY,
  descripcion TEXT NOT NULL
);

CREATE TABLE TBL_empleados  (
  id INTEGER PRIMARY KEY,
  nombre TEXT NOT NULL,
  apellido TEXT NOT NULL,
  salario  DEC NOT NULL,
  idGerencia INTEGER NOT NULL,
  idEducacion INTEGER NOT NULL,
  FOREIGN KEY (idGerencia) REFERENCES TBL_gerencias (id),
  FOREIGN KEY (idEducacion) REFERENCES TBL_nivel_educacion (id)
);


INSERT INTO TBL_gerencias VALUES (1, 'Gerencia 1', 'Mendoza'); 
INSERT INTO TBL_gerencias VALUES (2, 'Gerencia 2', 'Salta');
INSERT INTO TBL_gerencias VALUES (3, 'Gerencia 3', 'Entre Rios');

INSERT INTO TBL_nivel_educacion VALUES (1, 'Primario');
INSERT INTO TBL_nivel_educacion VALUES (2, 'Secundario');
INSERT INTO TBL_nivel_educacion VALUES (3, 'Terciario');

INSERT INTO TBL_empleados VALUES (1, 'JUAN', 'PEREZ', 405, 1, 1);
INSERT INTO TBL_empleados VALUES (2, 'MARCOS', 'SOSA', 605, 1, 2);
INSERT INTO TBL_empleados VALUES (3, 'JUAN', 'GOMEZ', 432, 2, 3);

SELECT tbl_empleados.nombre, tbl_empleados.apellido,
       tbl_nivel_educacion.descripcion
        FROM tbl_empleados
JOIN tbl_nivel_educacion on idEducacion = tbl_nivel_educacion.id  WHERE tbl_empleados.idGerencia 
IN (SELECT tbl_empleados.idGerencia FROM tbl_empleados GROUP BY tbl_empleados.idGerencia HAVING SUM(tbl_empleados.salario) > 430) 
ORDER BY tbl_empleados.apellido;
