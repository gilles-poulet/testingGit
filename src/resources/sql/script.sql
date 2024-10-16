CREATE TABLE IF NOT EXISTS Section (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(30) UNIQUE
);

CREATE TABLE IF NOT EXISTS Cours (
    id SERIAL PRIMARY KEY,
    id_section INTEGER
    REFERENCES Section(id) ON DELETE SET NULL,
    nom VARCHAR(30),
    CONSTRAINT unique_cours_per_section UNIQUE (id_section, nom)
);

CREATE TABLE IF NOT EXISTS Status (
    id SERIAL PRIMARY KEY,
    status VARCHAR(25) UNIQUE
);

CREATE TABLE IF NOT EXISTS Personne (
    id SERIAL PRIMARY KEY,
    id_status INTEGER
    REFERENCES Status(id) ON DELETE SET NULL,
    nom VARCHAR(15),
    prenom VARCHAR(15),
    CONSTRAINT unique_personne UNIQUE (nom, prenom)
);

CREATE TABLE IF NOT EXISTS Cours_Personne (
    id_personne INTEGER
    REFERENCES Personne(id) ON DELETE CASCADE,
    id_cours INTEGER REFERENCES Cours(id) ON DELETE CASCADE,
    annee INTEGER,
    PRIMARY KEY (id_personne, id_cours, annee),
    CONSTRAINT unique_cours_personne UNIQUE (id_personne, id_cours, annee)
);