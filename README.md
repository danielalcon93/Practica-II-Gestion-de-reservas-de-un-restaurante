Gestión de Restaurante - Bar Leyendas

Proyecto en Java que simula la gestión de un restaurante, permitiendo trabajar con clientes, reservas y consultas mediante streams.

Requisitos
Java 25
Maven

Instalación
1. Clonar el repositorio:
git clone <URL_DEL_REPOSITORIO>

2. Abrir el proyecto en IntelliJ

Ejecución

Ejecutar la clase Main

Funcionalidades
- Añadir clientes al sistema
- Crear reservas con fecha, hora, número de personas y zona
- Gestionar estados de reservas (PENDIENTE, CONFIRMADA, CANCELADA, ATENDIDA)
- Realizar consultas usando Streams:
- Reservas confirmadas por fecha
- Reservas de más de X personas
- Primera reserva cancelada
- Reservas ordenadas por número de personas
- Clientes con reservas grandes
- Total previsto de reservas atendidas
- Número de reservas por estado y zona
- Reservas agrupadas por fecha
- Cliente con más reservas
- Recaudación prevista por fecha
- Estadísticas de comensales
- Clientes ordenados alfabéticamente
- Reservas futuras agrupadas por fecha
- Porcentaje de reservas canceladas


Estructura
app → clase Main
modelo → Cliente, Reserva, EstadoReserva
servicio → Restaurante, RestauranteService

Autor
Daniel Fernández Alcón