insert into cliente values ("1", "pepe1", "direccion de mi casa", 20, "juanpepe@gnlkk.com", "PRUEBA_0", "imagen-url", "Juan Pablo Loaiza");
insert into cliente values ("2", "pepe1", "direccion de mi casa", 20, "juanpedde@gnlkk.com", "PRUEBA", "imagen-url", "Alfonso");
insert into cliente values ("3", "pepe1", "direccion de mi casa", 20, "juanpepec@gnlkk.com", "PRUEBA_0", "imagen-url", "Rodrigo");
insert into cliente values ("4", "pepe1", "direccion de mi casa", 20, "juanpepsdcsdc@gnlkk.com", "PRUEBA", "imagen-url", "Sigifredo");
insert into cliente values ("5", "pepe1", "direccion de mi casa", 20, "juanpcdepe@gnlkk.com", "PRUEBA_0", "imagen-url", "Roberto");

insert into cliente_telefonos values ("1", "31275848884");
insert into cliente_telefonos values ("1", "31275833884");
insert into cliente_telefonos values ("2", "31275848445");
insert into cliente_telefonos values ("3", "31275855858");
insert into cliente_telefonos values ("3", "31275896425");

insert into horario values (1, "LMXJV", "2022-10-02", "2022-09-20", "16:00");
insert into horario values (2, "JVSDL", "2022-10-29", "2022-10-15", "14:00");
insert into horario values (3, "LMXJVS", "2022-10-30", "2022-10-16", "20:00");
insert into horario values (4, "LMXJV", "2022-11-03", "2022-10-20", "16:00");
insert into horario values (5, "LMXJV", "2022-11-20", "2022-10-30", "16:00");

insert into tipo_sala values (1, "Estandar", 0);
insert into tipo_sala values (2, "VIP", 5500);
insert into tipo_sala values (3, "4D", 9600);

insert into distribucion_sillas values(1, 19, "xx xxx xxxx xxxx xxxx xxxx xx x x x xxx x x", 8, 190);
insert into distribucion_sillas values(2, 16, "xxxxxxx   xx x x   xxxx", 6, 190);
insert into distribucion_sillas values(3, 18, "xxxxx   x x x   x xxxxxxxx", 10, 190);
insert into distribucion_sillas values(4, 17, "xxxxx x x x   x x xxxxxx", 7, 190);
insert into distribucion_sillas values(5, 15, "xxx x xx xxxxx x xxx", 8, 120);

insert into ciudad values (1, "Armenia");
insert into ciudad values (2, "Pereira");
insert into ciudad values (3, "Manizales");
insert into ciudad values (4, "Bogotá");
insert into ciudad values (5, "Cali");

insert into administrador_teatro values ("1000", "1234", "jloasiisi@email.com", "urlImagen", "Jose Alonso Perez", "3127588409");
insert into administrador_teatro values ("2000", "1234", "jloasi22i@email.com", "urlImagen", "Pedro Antonio Marín", "3125506568");
insert into administrador_teatro values ("3000", "1234", "jloasiddi@email.com", "urlImagen", "María Teresa Nieto", "3124545840");
insert into administrador_teatro values ("4000", "1234", "jloasi45i@email.com", "urlImagen", "John Freddy Gomez", "3127495409");
insert into administrador_teatro values ("5000", "1234", "jloasitsi@email.com", "urlImagen", "Jose Alonso Perez", "3127448409");

insert into teatro values (1, "Barrio la aguapanela calle 2", "C.C Armenia", "1000", 1);
insert into teatro values (2, "Direccion equis de Pereira", "C.C Pereira", "5000", 2);
insert into teatro values (3, "Otra direccion, pero de Manizales", "C.C Unicentro", "2000", 3);
insert into teatro values (4, "Avenida Centenario, cerca al round point", "C.C Calima", "3000", 4);
insert into teatro values (5, "Por la 14, con KFC se reconoce de una", "C.C Portal del Quindio", "4000", 1);

insert into sala values (1, 1, 2, 4, 1);
insert into sala values (2, 2, 1, 4, 1);
insert into sala values (3, 1, 4, 2, 2);
insert into sala values (4, 1, 5, 5, 1);
insert into sala values (5, 2, 1, 5, 2);
insert into sala values (6, 3, 1, 5, 1);
insert into sala values (7, 4, 1, 5, 3);
insert into sala values (8, 1, 1, 1, 1);

insert into pelicula values (1, 120, 7, "EN_CARTELERA", "urlImagen", "Las Aventuras del Pescado",
                             "Antonio Director", "Universal", "sinopsis larga", "urlTrailer1");
insert into pelicula values (2, 152, 14, "EN_CARTELERA", "urlImagen", "Un aguacate en el desierto",
                             "Unos directores", "Marvel", "sinopsis larga", "urlTrailer2");
insert into pelicula values (3, 131, 14, "PROXIMAMENTE", "urlImagen", "Mandingo",
                             "Otros directores", "21th Fox", "sinopsis larga", "urlTrailer3");
insert into pelicula values (4, 110, 7, "FINALIZADA", "urlImagen", "Habia una vez una pelicula",
                             "Mi amigo el fotografo", "Disney", "sinopsis larga", "urlTrailer4");
insert into pelicula values (5, 98, 18, "EN_CARTELERA", "urlImagen", "Terror en la ciudad de Armenia",
                             "Pepe Aguilar", "Paramount", "sinopsis larga", "urlTrailer5");

insert into pelicula_generos values (1, "DRAMA");
insert into pelicula_generos values (1, "CIENCIA_FICCION");
insert into pelicula_generos values (1, "ACCION");
insert into pelicula_generos values (2, "FANTASIA");
insert into pelicula_generos values (2, "FANTASIA");
insert into pelicula_generos values (3, "DOCUMENTAL");
insert into pelicula_generos values (4, "AVENTURA");
insert into pelicula_generos values (4, "ACCION");
insert into pelicula_generos values (5, "TERROR");

insert into funcion values (1, 7500, 1, 4, 1);
insert into funcion values (2, 8000, 3, 3, 3);
insert into funcion values (3, 7500, 2, 1, 4);
insert into funcion values (4, 8000, 5, 2, 2);
insert into funcion values (5, 7500, 5, 5, 4);
insert into funcion values (6, 7500, 4, 5, 5);
insert into funcion values (7, 7500, 3, 5, 7);
insert into funcion values (8, 7500, 1, 5, 6);

insert into compra values (1, "2022-10-15", "MASTERCARD", 25600, "1", null, 1);
insert into compra values (2, "2022-10-18", "MASTERCARD", 82600, "1", null, 2);
insert into compra values (3, "2022-10-19", "MASTERCARD", 29600, "3", null, 3);
insert into compra values (4, "2022-10-26", "MASTERCARD", 118400, "4", null, 4);
insert into compra values (5, "2022-10-30", "MASTERCARD", 35600, "1", null, 5);

insert into cupon values (1, "Descuento de cumpleaños", 2, 10, "REDIMIDO", "2022-10-03", "1");
insert into cupon values (2, "Descuento de fidelidad", 3, 5, "ACTIVO", "2022-10-03", "2");
insert into cupon values (3, "Descuento de cumpleaños", 2, 10, "REDIMIDO", "2022-10-03", "3");
insert into cupon values (4, "Descuento de aniversario", 4, 8, "VENCIDO", "2022-10-03", "1");
insert into cupon values (5, "Descuento de VIP", 1, 15, "ACTIVO", "2022-10-03", "1");
insert into cupon values (6, "Descuento de cumpleaños", 2, 10, "REDIMIDO", "2022-10-06", "2");

insert into entrada values (1, 10, 11, 7800, 1);
insert into entrada values (2, 10, 12, 7800, 1);
insert into entrada values (3, 6, 8, 7800, 2);
insert into entrada values (4, 7, 13, 7800, 3);
insert into entrada values (5, 12, 14, 7800, 5);
insert into entrada values (6, 13, 14, 7800, 4);

insert into producto_confiteria values (1, null, "url-imagen-producto", "Combo 1", 22000);
insert into producto_confiteria values (2, null, "url-imagen-producto", "Combo 2", 18000);
insert into producto_confiteria values (3, null, "url-imagen-producto", "Combo 3", 35600);
insert into producto_confiteria values (4, null, "url-imagen-producto", "Combo 4", 12000);
insert into producto_confiteria values (5, null, "url-imagen-producto", "Combo 5", 26800);

insert into compra_confiteria values (1, 24000, 2, 1, 4);
insert into compra_confiteria values (2, 22000, 1, 2, 1);
insert into compra_confiteria values (3, 54000, 3, 3, 2);
insert into compra_confiteria values (4, 24000, 2, 1, 4);
insert into compra_confiteria values (5, 35600, 1, 5, 3);