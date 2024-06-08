--DROP TABLE IF EXISTS "IdeiaParticipante"
--DROP TABLE IF EXISTS "Ideia"
--DROP TABLE IF EXISTS "Pessoa";

CREATE TABLE IF NOT EXISTS  "Pessoa" (
	"id" serial,
	"nome" varchar(100) NOT NULL,
	"dataNascimento" date NOT NULL,
	PRIMARY KEY ("id"));

CREATE TABLE IF NOT EXISTS "Ideia" (
	"id" serial,
	"descricao" text NOT NULL,
	"idAutor" int NOT NULL,
	PRIMARY KEY ("id"),
	FOREIGN KEY ("idAutor") REFERENCES "Pessoa"("id"));

CREATE TABLE IF NOT EXISTS "IdeiaParticipante" (
	"idIdeia" int,
	"idParticipante" int,
	PRIMARY KEY ("idIdeia", "idParticipante"),
	FOREIGN KEY ("idIdeia") REFERENCES "Ideia"("id"),
	FOREIGN KEY ("idParticipante") REFERENCES "Pessoa"("id"));
