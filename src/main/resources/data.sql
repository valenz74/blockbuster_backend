/*INSERT INTO "PELICULA_CATALOGO" 
(release_date,vote_average, id_pelicula, original_language, overview,poster_path,title)
VALUES

(DATE '2012-04-25', 7.711, 1, 'en', 'When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!', '/RYMX2wcKCBAr24UyPD7xwmjaTn.jpg', 'The Avengers'),

(DATE '2018-04-25', 8.256, 2, 'en', 'As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.', '/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg', 'Avengers: Infinity War'),

(DATE '1998-12-31', 7.265, 3, 'en', 'The film is composed of receding planes in a landscape: a back garden and the houses beyond. The wooden lattice fence, visible in the image, marks the border between enclosed and open, private and public space, and forms both a fulcrum for the work and a formal grid by which the shots are framed and organised.', '/AfFD10ZqEx2vkxM2yvRZkybsGB7.jpg', 'Matrix'),

(DATE '2021-12-16', 6.496, 4, 'en', 'Plagued by strange memories, Neo''s life takes an unexpected turn when he finds himself back inside the Matrix.', '/8c4a8kE7PizaGQQnditMmI1xbRp.jpg', 'The Matrix Resurrections'),

(DATE '2019-08-01', 6.867, 5, 'en', 'Ever since US Diplomatic Security Service Agent Hobbs and lawless outcast Shaw first faced off, they just have traded smack talk and body blows. But when cyber-genetically enhanced anarchist Brixton''s ruthless actions threaten the future of humanity, they join forces to defeat him.', '/qRyy2UmjC5ur9bDi3kpNNRCc5nc.jpg', 'Fast & Furious Presents: Hobbs & Shaw'),

(DATE '2006-06-03', 6.454, 6, 'en', 'In order to avoid a jail sentence, Sean Boswell heads to Tokyo to live with his military father. In a low-rent section of the city, Shaun gets caught up in the underground world of drift racing', '/wTLaII3WAkQcsyiF4sI6PlXZ0dF.jpg', 'The Fast and the Furious: Tokyo Drift');

*/

/*La contraseña del usuario tipo USER es usuario, y la de ADMIN es holamundo*/
INSERT INTO "USUARIO" (email, password, rol)VALUES
('admin@email.com','$2a$10$SgsltMHoYYbT9HtV.xkPTetlJE8M7lPipCCcPEiENG96BglYzo4Gq',	'ADMIN'),
('user0@email.com', '$2a$10$2T7FGc/JKLFfdwe9ooTBZuiKWj1TmpUz7sfrOzo7dMSES.B4OzUfC', 'USER'),
('user1@email.com', '$2a$10$2T7FGc/JKLFfdwe9ooTBZuiKWj1TmpUz7sfrOzo7dMSES.B4OzUfC', 'USER'),
('user2@email.com', '$2a$10$2T7FGc/JKLFfdwe9ooTBZuiKWj1TmpUz7sfrOzo7dMSES.B4OzUfC', 'USER'),
('user3@email.com', '$2a$10$2T7FGc/JKLFfdwe9ooTBZuiKWj1TmpUz7sfrOzo7dMSES.B4OzUfC', 'USER');

/*
INSERT INTO "PELICULA_ALQUILADA" (usuario_id, pelicula_catalogo_id_pelicula)VALUES
(2,1),
(2,2),
(3,1),
(3,2),
(4,3),
(4,4);
*/