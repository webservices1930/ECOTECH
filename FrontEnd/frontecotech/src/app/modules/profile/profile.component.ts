import { Component, OnInit } from '@angular/core';
import { SoapService } from 'src/app/services/soap.service';
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
    user: User;
    u: User;
    c: Cliente;
    p: Proveedor;

    constructor(
        private service: UserService,
        private soapService: SoapService) {
    }
    ngOnInit() {
        this.soapService.client.then(client => {
            this.service.decode().subscribe(res => {
                this.u = res;
                this.nickname = this.u.nickname;
                console.log(this.nickname);
            });
        });

        this.soapService.client.then(client => {
            this.service.getUserByNickName(this.nickname, client as Client).subscribe(res => {
                this.user = res.result.return;
                console.log(this.user);
                if (this.user.rolUsuario === 'PROVEEDOR') {
                    this.soapService.client.then(client => {
                        this.service.getProviderByNickname(this.nickname, client as Client).subscribe(res => {
                            this.p = res.result.return;
                            console.log(this.p);
                        });
                    });
                }

                if (this.user.rolUsuario === 'CLIENTE') {
                    this.soapService.client.then(client => {
                        this.service.getClienteByNickname(this.nickname, client as Client).subscribe(res => {
                            this.c = res.result.return;
                            console.log(this.c);
                        });
                    });
                }
            });
        });
    }
}
