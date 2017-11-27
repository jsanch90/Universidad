CREATE TABLE Arbitro(
idArbitro int NOT NULL,
nombre VARCHAR(20) NOT NULL,
apellido1 VARCHAR(20) NOT NULL,
apellido2 VARCHAR(29),
tipo_de_arbitro int NOT NULL,
PRIMARY KEY (idArbitro));

CREATE TABLE Partido_Final(
idEquipo_Campeon int NOT NULL,
idEquipo_Subcampeon int NOT NULL,
idJugador_goleador int NOT NULL,
Marcador VARCHAR(5) NOT NULL,
FOREIGN KEY (idEquipo_Campeon) REFERENCES Equipo(idEquipo),
FOREIGN KEY (idEquipo_Subcampeon) REFERENCES Equipo(idEquipo),
FOREIGN KEY(idJugador_goleador) REFERENCES Jugador(idJugador));

CREATE TABLE Cancha(
idCancha int NOT NULL,
capacidad int NOT NULL,
medida int NOT NULL,
PRIMARY KEY (idCancha));

CREATE TABLE Equipo (
idEquipo INT NOT NULL,
nombre VARCHAR(30) NOT NULL,
eslogan VARCHAR(50) NOT NULL,
puntos INT NOT NULL,
PRIMARY KEY (idEquipo));

CREATE TABLE Partido (
idPartido int  NOT NULL,
idEquipo_L int NOT NULL,
idEquipo_V int NOT NULL,
tiempo int NOT NULL,
idCancha int NOT NULL,
Informe_idInforme int NOT NULL,
PRIMARY KEY (idPartido),
FOREIGN KEY (idEquipo_L) REFERENCES Equipo (idEquipo),
FOREIGN KEY (idEquipo_V) REFERENCES Equipo (idEquipo),
FOREIGN KEY (idCancha) REFERENCES Cancha (idCancha),
FOREIGN KEY (Informe_idInforme) REFERENCES Informe (idInforme));

CREATE TABLE Informe (
idInforme INT NOT NULL,
idPartido INT NOT NULL,
marcador VARCHAR(5) NOT NULL,
idSancionados INT NOT NULL,
PRIMARY KEY (idInforme),
FOREIGN KEY (idSancionados) REFERENCES Sancionados (idSancionados));

CREATE TABLE Jugador(
idJugador int NOT NULL,
nombre VARCHAR(20) NOT NULL,
apellido1 VARCHAR(20) NOT NULL,
apellido2 VARCHAR(20) NOT NULL,
numero int NOT NULL,
num_goles int NOT NULL,
estado boolean NOT NULL,
idEquipo int NOT NULL,
PRIMARY KEY (idJugador),
FOREIGN KEY (idEquipo) REFERENCES Equipo(idEquipo));

CREATE TABLE Sancionados(
idSancionados int NOT NULL,
tipo_sancion int NOT NULL,
idJugador int NOT NULL,
PRIMARY KEY (idSancionados),
FOREIGN KEY (idJugador) REFERENCES Jugador(idJugador));

CREATE TABLE Premiacion(
idPremiacion int NOT NULL,
idEquipo_campeon int NOT NULL,
idEquipo_subcampeon int NOT NULL,
Marcador VARCHAR(5) NOT NULL,
idJugador_goleador int not NULL,
PRIMARY KEY (idPremiacion),
FOREIGN KEY(IdEquipo_campeon) REFERENCES  Equipo(idEquipo),
FOREIGN KEY(IdEquipo_subcampeon) REFERENCES Equipo(idEquipo),
FOREIGN KEY(IdJugador_goleador) REFERENCES Jugador(idJugador));

CREATE TABLE Partido_Arbitro(
idPartido int NOT NULL,
idArbitro_C int NOT NULL,
idArbitro_L1 int NOT NULL,
idArbitro_L2 int NOT NULL,
idArbitro_Cuarto int NOT NULL,
PRIMARY KEY (idPartido, idArbitro_C, idArbitro_L1, idArbitro_L2, idArbitro_Cuarto),
FOREIGN KEY (idPartido) REFERENCES Partido (idPartido),
FOREIGN KEY (idArbitro_C) REFERENCES Arbitro (idArbitro),
FOREIGN KEY (idArbitro_L1) REFERENCES Arbitro (idArbitro),
FOREIGN KEY (idArbitro_L2) REFERENCES Arbitro (idArbitro),
FOREIGN KEY (idArbitro_Cuarto) REFERENCES Arbitro (idArbitro));
€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€kd€ku€ku€ku€ku€ku€ku€ku€kussdfsdfsdfsdsqqqqqquir€kbquitquitquitquit