export class Service {
    contacto: string;
    costo: number;
    descripcion: string;
    latitud: number;
    longitud: number;
    nombre: string;
    tipo: string;
    id: string;
}

export class Paseo extends Service {
    horaSalida: string;
    horaLlegada: string;
    trayecto: string;
    restricciones: string;
    sugerencias: string;
}

export class Alimentacion extends Service {
    tipoComida: string;
}

export class Alojamiento extends Service {
    numHabitaciones: number;
    numHuespedes: number;
    extras: string;
}

export class Otro extends Service {
    tipoServicio: string;

}

export class Transporte extends Service {

    horaSalida: string;
    horaLlegada: string;
}

export enum TypeService {
  Paseo,
  Alimentacion,
  Alojamiento,
  Otro,
  Transporte
}
