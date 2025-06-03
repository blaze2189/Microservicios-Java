# Microservicio Java

- Dos microservicios:
  - [airport-api](./airport-api): catálogo de vuelos, ciudades, países, frecuencias y aerolíneas.
  - [sales-api](./sales-api): catálogo de aviones y vuelos, endpoints para realizar compra de vuelos y consulta de vuelos. 

## [airport-api](./airport-api)

Consulta de endpoints mediante [swagger](http://localhost:8082/swagger-ui/index.html).

## [sales-api](./sales-api)

Ejecución de compra (PUT): http://localhost:8083/flight/buy/{flightCode}/{tickets}
 lista de flightCode vàlidos:
-  MAM019
-  TAM019
-  WAM019
-  FAM019
-  SAM019
-  FAM020
-  MAM020
-  UAM020
-  TAM018

tickets es la cantidad de boletos a comprar.

Bùsqueda de vuelos disponibles: [http://localhost:8083/flight?from=CITYO&to=CITYT&date=FECHA](http://localhost:8083/flight?from=NY&to=CDMX&date=08-07-25)
donde 
CITYTO es la ciudad de origin.  
CITYT es la ciudad de destino.  
FECHA la fecha del vuelo que se requiere.  

Valores vàlidos para CITYT y CITYO: CDMX y NY.


### Testing project

- Run `docker compose pull` (idescargara las imagenes necesarias)
- Run `docker compose up` para iniciar los servicios.
- En un navegador entrar a `http://localhost:8082/swagger-ui/index.html` para entrar a la api de aeropuerto (`airport-api`).