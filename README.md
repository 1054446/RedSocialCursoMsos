--

Pasos iniciales.

- Asegurarse de tener las herramientas instaladas
- Entrar a la carpeta raiz a la altura del archivo docker-compose.yml
- Ejecutar el comando docker-compose up --build para levantar la bd 
- los datos de conexion a la base de datos son
BD: redsocial
user y pwd: admin
Se crean las tablas y por ahora hay que ejecutarlas manualmente para tener la estructura deseada, utilizando el archivo CreateDB.sql


Se agrego un servicio rest con maven para conectar y ralizar el crud de mensajes y chats
temporalmente el servicio tiene mapeada una ip en la url de conexion a la bd, esta cambiarla por localhots o ip depende del ambiente que levantes

Actualizar el archivo dockerfile de postgres subiendolo de version a la misma que la del servicios

