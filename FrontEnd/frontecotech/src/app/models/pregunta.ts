import { User } from './user.model';

export class Pregunta {
    id?: string;
    descripcion: string;
    fecha?: string;
    respuesta?: string;
    cliente?: User;
}
