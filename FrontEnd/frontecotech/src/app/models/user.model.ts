export class User {
  id?: string;
  nombre?: string;
  descripcion?: string;
  correo?: string;
  foto?: string;
  fechaNacimiento?: Date;
  nickname: string;
  password?: string;
  rolUsuario?: string;
}
export class Proveedor extends User {
  telefono?: string;
  web?: string;
  usuarioTwitter?: string;
  usuarioFacebook?: string;
  usuarioInstagram?: string;
}

export class Cliente extends User {
  di?: string;
}
