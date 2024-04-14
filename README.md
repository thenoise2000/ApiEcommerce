
Api rest para consulta de precios de un ecommerce

Con los siguientes datos

PRICES
-------
 
BRAND_ID         START_DATE                                    END_DATE                        PRICE_LIST                   PRODUCT_ID  PRIORITY                 PRICE           CURR
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1         2020-06-14-00.00.00                        2020-12-31-23.59.59                        1                        35455                0                        35.50            EUR
1         2020-06-14-15.00.00                        2020-06-14-18.30.00                        2                        35455                1                        25.45            EUR
1         2020-06-15-00.00.00                        2020-06-15-11.00.00                        3                        35455                1                        30.50            EUR
1         2020-06-15-16.00.00                        2020-12-31-23.59.59                        4                        35455                1                        38.95            EUR
 
Campos: 
 
BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
PRICE_LIST: Identificador de la tarifa de precios aplicable.
PRODUCT_ID: Identificador código de producto.
PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
PRICE: precio final de venta.
CURR: iso de la moneda.

En donde se pide construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:
 
Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
 
Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).
              
Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:
                                                                                       
-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

Se desarrollo una API REST para el registro de usuarios con Spring Boot y empleando una DB en memoria H2.

Herramientas

- Java 17

- SpringBoot

- JPA

- H2

- Maven

- Junit

Para instalar

Clonamos o desacargamos el repositorio git clone https://github.com/thenoise2000/ApiEcommerce
Dirijase a la raiz del proyecto: cd ApiEcommerce
Compilamos: mvn clean install
Ejecutamos mvn spring-boot:run

Para desplegarlo ejecute

comando
  mvn spring-boot:run

Pruebas en las Api:

Url de pruebas para la Api = http://localhost:8080/api/findPrice

Ejemplo

image//


parametros de entrada de las pruebas:

{
   "date": "2020-06-14T00:00:00",
   "productId": "35455",
   "brandId" : 1
}

Formato de salida exitosa esperada:

{
    "brandId": 1,
    "startDate": "2020-06-14T00:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": "EUR35,50",
    "priceList": 1,
    "productId": 35455
}

Para ejecutar tests

-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

 utilice el comando:

  bash
  mvnw test

  O ejecutelos en el IDE de su preferencia

                  
                      
                      
                                  /** Analisis Domain Driven Design **/

Domain Driven Design consiste, principalmente, en dos procesos: el modelado del dominio y la implementación de la lógica del dominio

Arquitectura (Architecture)

Segun (Murillo Paredes. Universisdad de Alcala, 2021) Para el diseño e implementación de cualquier aplicación se tienen que realizar
múltiples tipos de tarea:

lógica de negocio, interacción con el usuario, comunicación otros sistemas, etc. Si se mezclan las responsabilidades entre las diferentes tareas se obtienen sistemas acoplados, poco cohesionados, complejos y difícilmente mantenibles y probables.

Las arquitecturas por capas son de gran utilidad para paliar la problemática mencionada anteriormente. El principio esencial que sustenta
este tipo de arquitecturas es que un componente de una capa solo depende de otros componentes de esta o de capas inferiores, promoviendo
el bajo acoplamiento y la alta cohesión. Evidentemente la elección de cada una de estas capas toma un papel relevante para un buen diseño arquitectónico. Como definición clásica, este tipo de arquitectura se suele dividir en las siguientes capas:

• Capa de presentación. Muestra la información e interpreta las acciones realizadas por los usuarios

• Capa de aplicación. Coordina las diferentes interacciones de una tarea y delega el trabajo en los colaboradores de dominio. 
  No contiene lógica de negocio

• Capa de dominio. Representa las reglas de negocio. Suele ser denominada como “el corazón del negocio”

• Capa de infraestructura. Proporciona mecanismos para la integración con proveedores externos: persistencia de los objetos de dominio,     comunicación mediante mensajes, etc.

image//

Es necesario concentrar todo el código relativo al modelado de dominio en una única capa y aislarla del resto de tareas asociadas. Los componentes de la capa de dominio no tienen como responsabilidad mostrar información al usuario, persistir sus propios datos, etc.

Los beneficios que se contienen con el uso de este tipo de arquitectura son:
• Código fácil de leer, entender, cambiar y mantener
• Código simétrico (predecible)
• Alta cohesión y bajo acoplamiento
• Modelos de dominio enriquecido
• Componentes aislados y separados por su responsabilidad
• Facilidad de realización de pruebas
• Útil para sistemas distribuidos
• Flexibilidad en el diseño

Para el diseño de aplicación que siguen el patrón DDD se suele utilizar la arquitectura hexagonal ya que aísla el modelado del dominio 
de los componentes externos. Este aislamiento permite que los cambios en los componentes externos no afecten al modelado del dominio.
Los cambios en el dominio solo deben permitirse cuando son realizados por criterios del negocio. Los puertos son una definición del 
contrato público y los adaptadores son la implementación de un puerto para un contexto en concreto.

image//

Para este caso de analisis de esta arquitectura por capas implementamos el flujo de una petición REST en la arquitectura hexagonal 
en donde el controlador forma parte de la capa de infraestructura y delega en un servicio de la capa aplicación la ejecución de la 
acción requerida por el usuario. El servicio de la capa de aplicación representa el caso de uso de manera atómica y coordina con ayuda
de los elementos de la capa de dominio las tareas asociadas a este. 

image//


Para abordar este requerimiento desde una perspectiva de Domain-Driven Design (DDD), podemos identificar tres entidades principales en el contexto del problema:  Price ,  Brand  y  Product . Cada una de estas entidades tiene su propia identidad y atributos específicos que se relacionan entre sí en el dominio del comercio electrónico. 

image//

**Price (Precio)** 
   - Atributos:  id ,  brand ,  product ,  startDate ,  endDate ,  priceList ,  priority ,  price ,  currency . 
   - Relaciones: Se relaciona con  Brand  y  Product . 

**Brand (Cadena)** 
   - Atributos:  id ,  name . 
   - Relaciones: Puede tener múltiples precios asociados. 

**Product (Producto)** 
   - Atributos:  id ,  name . 
   - Relaciones: Puede tener múltiples precios asociados. 

Para implementar la funcionalidad solicitada en Spring Boot, podemos seguir los siguientes pasos: 
 
1. **Definir las Entidades:** Crear las clases Java que representen las entidades  Price ,  Brand  y  Product , con sus atributos y relaciones correspondientes. 
 
2. **Definir los Repositorios:** Crear interfaces de repositorio para cada entidad que permitan acceder a los datos en la base de datos. 
 
3. **Implementar el Servicio de Consulta de Precios:** Crear un servicio que contenga la lógica para consultar los precios aplicables según los parámetros de entrada recibidos (fecha de aplicación, identificador de producto, identificador de cadena). 
 
4. **Crear el Controlador REST:** Implementar un controlador REST en Spring Boot que exponga un endpoint para la consulta de precios. Este controlador invocará al servicio creado en el paso anterior. 
 
5. **Manejar las Excepciones:** Implementar un manejo adecuado de excepciones para casos como precios no encontrados, fechas no válidas, etc. 
 
6. **Pruebas Unitarias:** Es importante realizar pruebas unitarias para validar el comportamiento de los servicios y controladores. 

