# ARCHITECTURE OF MASSIVELY DISTRIBUTED APPLICATIONS

**URL GitHub:** https://github.com/camrojass/twiterlab_API.git

## Descripción
Repositorio de APIs prototipo para realizar publicación, lectura individual, lectura en lista y eliminación de tweets.

## Indice
1. [Análisis del problema e identificación de recursos.](#id1)
2. [Recursos técnicos de la solución](#id2)
3. [Arquitectura solución](#id3)
4. [Implementación un prototipo de la aplicación en AWS](#id4)
5. [Evidencia](#id5)
6. [Autores](#id6)

## Análisis del problema e identificación de recursos. <a name="id1"></a>

### Catálogo de servicios
| Recurso | Operación | URL                  | Descripción                                                     |
|---------|-----------|----------------------|-----------------------------------------------------------------|
| Posteo  | GET       | /twitter/post/       | Lista los posteos registrados de la solución                    | 
| Posteo  | GET       | /twitter/post/{id}   | Obtiene el posteo con id = {id} registrado en la solución       | 
| Posteo  | DELETE    | /twitter/post/{id}   | Elimina el posteo creado con {id} de la solución                | 
| Posteo  | POST      | /twitter/post/       | Crea un nuevo post en la solución                               | 

### Representación de recursos
```java
public class Post {

    private String id;              //ID de BD dynamo auto-generado
    private String sender;          //Usuario que realiza la publicación
    private String comment;         //mensaje en texto de la publicación
    private Date date;              //fecha de la publicación
    private boolean IsPrivate;      //Publicación es privada (no todos pueden verla)
	}
```
## Recursos técnicos de la solución <a name="id2"></a>
- Java 8.

Usado para el desarrollo de la solución. Como punto adicional, se incluyeron recursos adicionales para integrar la solución en DynamoDB
- Maven.

Framework de java usado para el desarrollo de la solución
- Serverless Framework.

Usado para el deploy de la solución.
- AWS API Gateway.

A través de los lambas se creo la solución
- Dynamo DB.

Base de datos donde se almaceno la solución.
- node.js.

Requerido para instalar severless en la máquina local

## Arquitectura solución <a name="id3"></a>
![APIs](https://github.com/camrojass/twiterlab_API/assets/100396227/ddba6836-42bc-44d6-896b-87eb8b14fb44)
En la imagen se evidencia los componente que hacen parte de la solución. El gateway que realiza la orquestación de peticiones HTTP, las lambdas, las cuales, son servicios independientes que componen cada una de las peticiones posibles (POST, GET, DELETE) y la base de datos en Dynamo DB de los posteos realizados.

## Implementación un prototipo de la aplicación en AWS <a name="id4"></a>

La forma de implementación utilizada para esta solución implico el framework Serverless. Para utilizarlo, se debe tener en cuenta los siguientes pre requisitos

1. Tener previamente instalado y configurado Node.js en su entorno local
2. Instalar el framework Serverless (A través del cmd, ejecutar el siguiente comando)
```bash
npm install -g serverless
```
3. Una vez la solución está desarrollada, hacer el build de la solución con el siguiente comando
```bash
mvn clean install
```
4. Invocar el comando 'Serverless', y configurar en caso de ser necesario las credenciales de AWS y permisos de IAM para automatizar el despliegue de componentes definido en el archivo serverless.yml

    - Guía de configuración : [Ver link](https://www.serverless.com/framework/docs/tutorial)

Haga clic en el link a continuación para ver el archivo [serverless.yml](serverless.yml)

5. Invocar el siguiente comando
```bash
serverless deploy
```

## Evidencia <a name="id5"></a>
### Vista de recursos publicados en aws
![image](https://github.com/camrojass/twiterlab_API/assets/100396227/68979aee-240f-40bd-b3d2-8cf9de18c5bf)


## Autores <a name="id6"></a>
* **Camilo Alejandro Rojas** - *Trabajo y documentación* - [camrojass](https://github.com/camrojass)
