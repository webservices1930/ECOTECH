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

export class Paseo extends Service{
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
    numHabaitaciones: number;
    numHuespedes:  number;
    extras: String;
}

export class Otro extends Service {
    tioServicio: String;

}

export class Transporte extends Service {

    horaSalida: string;
    horaLlegada: string;
}