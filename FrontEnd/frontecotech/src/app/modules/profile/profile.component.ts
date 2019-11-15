import { Component, OnInit } from '@angular/core';
import { Client } from 'ngx-soap';
import { UserService } from 'src/app/services/user.service';
import { User, Cliente, Proveedor } from 'src/app/models/user.model';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})

export class ProfileComponent implements OnInit {

    nickname: string;
    user: any;
    u: User;

    constructor(
        private service: UserService,
    ) {
    }
    ngOnInit() {
      this.service.decode().subscribe(res => {
        this.u = res;
        this.nickname = this.u.nickname;
        console.log(this.nickname);

        this.service.getUserByNickName(this.nickname).subscribe(res => {
          this.user = res;
          console.log(this.user);
          /*
          if (this.user.rolUsuario === 'PROVEEDOR') {
              this.soapService.client.then(client1 => {
                  this.service.getProviderByNickname(this.nickname, client1 as Client).subscribe(res1 => {
                      this.p = res1.result.return;
                      console.log(this.p);
                  });
              });
          }

          if (this.user.rolUsuario === 'CLIENTE') {
              this.soapService.client.then(client1 => {
                  this.service.getClienteByNickname(this.nickname, client1 as Client).subscribe(res1 => {
                      this.c = res1.result.return;
                      console.log(this.c);
                  });
              });
          }*/
        });
      });

    }
}
