
    create table usuario (
idUsuario SERIAL PRIMARY KEY,
nombreUsuario VARCHAR ( 50 ) UNIQUE NOT NULL,
contrasenia VARCHAR ( 50 ) NOT NULL,
correo VARCHAR ( 50 ) UNIQUE NOT NULL,
imagen bytea
);



create table chats(
idChat SERIAL PRIMARY KEY,
idUsuarioOrigen INT NOT NULL,
idUsuarioDestino INT NOT NULL
);


create table mensajes(
idMensaje SERIAL PRIMARY KEY,
idChat INT NOT NULL,
fechaHora TIMESTAMP,
texto VARCHAR ( 500 ) NOT NULL,
visto BOOLEAN
);



create table amigos(
id SERIAL PRIMARY KEY,
idUsuarioOrigen INT NOT NULL,
idUsuarioAmigo INT NOT NULL
);

insert  into usuario (nombreusuario,contrasenia,correo,imagen) values ('joerk','123456','jjoerk@gmail.com','sdgfvhasdfsdf354sdf4554asd5f64sdf/sdf/asdf54df/sdaf');
insert  into usuario (nombreusuario,contrasenia,correo,imagen) values ('Julio Cesar Moreno','123456','juliocmoreno@gmail.com',null);
insert  into usuario (nombreusuario,contrasenia,correo,imagen) values ('Jesus','123456','jesus@gmail.com',null);