Serie de pasos de lo realizado:

1. Setup Inicial
Primero, para crear el código, se configuro postgreSQL en application.properties (con Docker)

2. Entidades de Dominio
Se comenzó a crear las entidades del dominio (las del diagrama de dominio)
    - Tarea
    - EstadoTarea
    - PrioridadTarea
    - ListaDeTarea
Como estas entidades son las que irán a la base de datos, se declararon las clases con:
    @Entity: Declara que una clase es una entidad JPA
    @Table: Permite especificar el nombre que irá a la base de datos.

    Anotaciones para atributos:
    @Id: Declara un atributo como PK
    @GeneratedValue: (sirve para el UUID?)
    @Column: Declara el nombre de la columna y se le puede asignar propiedades (si se puede actualizar, si es nulleable)

    Para un atributo que esta en una relacion:

    Muchos a uno
    ------------
    @ManyToOne: Indica que esta clase es parte de una relacion muchos a uno. Como parametro se puede poner fetch = FetchType.LAZY para indicar que el atributo referenciado con la FK no será traida de la base de datos a no ser que sea requerida.
    @JoinColumn: Especifica el nombre de la columna de la FK

    Uno a muchos
    -------------
    @OneToMany: El atributo anotado con OneToMany pertenece a una relacion de Uno a Muchos entre dos entidades. El parametro mappedBy = "nombreColumna" indica la variable que tendrá la FK de la relacion. ademas se le puede agregar efectos cascada por ejemplo, por si se borra la lista, se borran sus tareas.

Como aclaracion, a cada clase se le debe agregar los constructores (con todos sus parametros), metodos equals y toString.

3. Armar DTO

Java Records: Sirven para crear clases portadoras de datos inmutables de forma rápida y eliminando el código repetitivo. Ventajas:
    - Permite generar todo el código necesario sin necesidad de escribir: 
        - constructores
        - atributos private final
        - métodos de lectura
        - implementaciones de equals, hashcode y tostring
    - Ideal para DTOs: Devolver datos de una API o base de datos.

DTO: "Objeto de Transferencia de Datos" sirve para transportar datos entre el cliente (como una página web o una app móvil) y el servidor (tu API).

Ejemplo práctico, si tenemos una clase Usuario con email, nombre de usuario, contraseña y la API devuelve todos sus datos, se podria filtrar la contraseña, los DTO sirven para enviar solo lo que deberia verse o para definir el contrato del tipo de objeto que la API espera recibir.

Teniendo en cuenta los conceptos anteriores. Se deben crear los DTO de las entidades creadas teniendo en cuenta los atributos que estarán expuestos a la API.

4. Mapeador de DTOs
Se necesita un mapeador que mapee los DTO con las entidades reales, para ello hay dos opciones:
    - Se puede usar alguna libreria
    - Se puede implementar a mano

Si se implementa a mano, lo ideal seria tener una interfaz que tenga los metodos que deba poseer las implementaciones.

Como debemos inyectar esta clase en nuestra API, debemos anotarla con la anotación estereotipo @Component (spring inyectara un bean de esta clase al Spring Context)

