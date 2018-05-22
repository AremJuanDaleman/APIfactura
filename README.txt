Integrantes de la asociación:
Juan José Andrade Pardo
Daniel Felipe Moreno D’aleman
Daniel Castiblanco
En el siguiente repositorio encontrarán un API que permite transformar un JSON  en facturas distintas. En este caso está disponible una factura sencilla para un cliente, y una factura en formato XML que se le enviaría a la DIAN en caso de declaración de impuestos.
Link de la API:
https://aremfinalapi.herokuapp.com/
Ejemplo de como usar la API:
Existen dos posibilidades: 
Para la factura de la DIAN https://aremfinalapi.herokuapp.com/dian?factura= seguido del JSON usando como mínimo los parámetros mostrados en el link de abajo.
https://aremfinalapi.herokuapp.com/dian?factura={%22numfac%22:%221234%22,%22numempresa%22:%221%22,%22empresa%22:%22Loscracks%22,%22valor%22:%22500000%22}
Para la factura del cliente https://aremfinalapi.herokuapp.com/cliente?factura= seguido del JSON.
