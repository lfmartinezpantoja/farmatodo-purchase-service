# farmatodo-purchase-service


Servicio para registrar compras por parte de clientes registrados en farmatodo-service, tanto los productos a comprar como la
tienda debe estar registrada en el servicio farmatodo-service, para poner a correr el servicio siga los siguientes pasos:
se deben seguir los siguientes pasos:
1. usando una imagen de docker mysql:5.7.5 se debe ejecutar el comando: sudo docker run -p 3306:3306 --name farmatodo  -e MYSQL_ROOT_PASSWORD=F4rM4t0D0d4T4b4S3 -d mysql:5.7.5
2. cuando el contenedor este corriendo se debe crear la base de datos el cual se encuntra en el repositorio extras,
   usando el script farmatodo.sql el cual contiene todas la tablas usadas por el servicio.
3. clonar los repositorios: configuration-service, farmatodo-login-service, farmatodo-service.
4. en el IDE preferido correr los servicios en el siguiente orden: configuration-service, farmatodo-login-service, farmatodo-service
   y por ultimo farmatodo-purchase-service
5. usando  la collecion de postman farmatodo del repositorio  extras  se puede realizar  peticiones al servicio usando postman o curl. 
