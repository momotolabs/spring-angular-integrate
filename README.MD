# Prueba de integracion y consumo de endpoint

En esta prueba se han integado el consumo de un endpoint
`https://catfact.ninja/fact` 

Para la prueba de construyen  3 servicios que se ejecutan con contenedores de docker los cuales son :

- api_quote: contendor construido con spring boot consume y guarda los datos de la consulta al endpoint
- frontend_quote: contenedor que lanza un servicio de nginx que carga los componentes construidos para mostrar los datos que se han cargado desde el contenedor del api_quote 
- database_quote: contenedor de base de datos usando el gestor oracle 10g

