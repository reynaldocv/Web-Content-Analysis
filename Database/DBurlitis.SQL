/*
Created: 5/10/2018
Modified: 5/10/2018
Model: PostgreSQL 9.2
Database: PostgreSQL 9.2
*/


-- Create tables section -------------------------------------------------

-- Table projeto

CREATE TABLE "projeto"(
 "pro_id" Bigint NOT NULL,
 "numero" Bigint NOT NULL
)
;

-- Add keys for table projeto

ALTER TABLE "projeto" ADD CONSTRAINT "Key1" PRIMARY KEY ("pro_id")
;

-- Table site

CREATE TABLE "site"(
 "sit_id" Bigint NOT NULL,
 "url" Character varying(100) NOT NULL,
 "pro_id" Bigint
)
;

-- Create indexes for table site

CREATE INDEX "IX_Relationship5" ON "site" ("pro_id")
;

-- Add keys for table site

ALTER TABLE "site" ADD CONSTRAINT "Key2" PRIMARY KEY ("sit_id")
;

-- Table analise

CREATE TABLE "analise"(
 "ana_id" Bigint NOT NULL,
 "sta_id" Bigint,
 "sit_id" Bigint
)
;

-- Create indexes for table analise

CREATE INDEX "IX_Relationship3" ON "analise" ("sta_id")
;

CREATE INDEX "IX_Relationship4" ON "analise" ("sit_id")
;

-- Add keys for table analise

ALTER TABLE "analise" ADD CONSTRAINT "Key3" PRIMARY KEY ("ana_id")
;

-- Table status

CREATE TABLE "status"(
 "sta_id" Bigint NOT NULL,
 "nombre" Character varying(20),
 "descripcao" Character varying(20)
)
;

-- Add keys for table status

ALTER TABLE "status" ADD CONSTRAINT "Key4" PRIMARY KEY ("sta_id")
;

-- Table politica

CREATE TABLE "politica"(
 "pol_id" Bigint NOT NULL,
 "descripcion" Character varying(20) NOT NULL
)
;

-- Add keys for table politica

ALTER TABLE "politica" ADD CONSTRAINT "Key5" PRIMARY KEY ("pol_id")
;

-- Table analisedetalle

CREATE TABLE "analisedetalle"(
 "ana_det_id" Bigint NOT NULL,
 "ana_id" Bigint,
 "pol_id" Bigint
)
;

-- Create indexes for table analisedetalle

CREATE INDEX "IX_Relationship7" ON "analisedetalle" ("ana_id")
;

CREATE INDEX "IX_Relationship8" ON "analisedetalle" ("pol_id")
;

-- Add keys for table analisedetalle

ALTER TABLE "analisedetalle" ADD CONSTRAINT "Key6" PRIMARY KEY ("ana_det_id")
;

-- Table reporte_estado

CREATE TABLE "reporte_estado"(
 "rep_id" Bigint NOT NULL,
 "ana_id" Bigint
)
;

-- Create indexes for table reporte_estado

CREATE INDEX "IX_Relationship9" ON "reporte_estado" ("ana_id")
;

-- Add keys for table reporte_estado

ALTER TABLE "reporte_estado" ADD CONSTRAINT "Key7" PRIMARY KEY ("rep_id")
;
-- Create relationships section ------------------------------------------------- 

ALTER TABLE "analise" ADD CONSTRAINT "Relationship3" FOREIGN KEY ("sta_id") REFERENCES "status" ("sta_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "analise" ADD CONSTRAINT "Relationship4" FOREIGN KEY ("sit_id") REFERENCES "site" ("sit_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "site" ADD CONSTRAINT "Relationship5" FOREIGN KEY ("pro_id") REFERENCES "projeto" ("pro_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "analisedetalle" ADD CONSTRAINT "Relationship7" FOREIGN KEY ("ana_id") REFERENCES "analise" ("ana_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "analisedetalle" ADD CONSTRAINT "Relationship8" FOREIGN KEY ("pol_id") REFERENCES "politica" ("pol_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "reporte_estado" ADD CONSTRAINT "Relationship9" FOREIGN KEY ("ana_id") REFERENCES "analise" ("ana_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;




