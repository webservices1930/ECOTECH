import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario';
import { ProfileService } from 'src/app/services/profile.service';
import { SoapService } from 'src/app/services/soap.service';
import { Client } from 'ngx-soap';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})

export class ProfileComponent implements OnInit {

    nickname: string;
    user: Usuario;

    constructor(
        private service: UserService,
        private soapService: SoapService) {
    }
    ngOnInit() {
        this.nickname = "abc123";
        this.soapService.client.then(client => {
            this.service.getUserByNickName(this.nickname, client as Client).subscribe(res => {
                this.user = res.result.return;
                console.log(this.user);
            });
        });
    }
}
