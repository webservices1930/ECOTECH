import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})

export class ProfileComponent implements OnInit {

    nickname: String;
    user: Usuario;

    constructor(private service: ProfileService) {
        
    }
    ngOnInit() {}

    getUser(nickname: String) {
        nickname = "abc123";
        this.service.searchByNickname(nickname).subscribe(res => {
            this.user = res.result.return;
            console.log(this.user);
        });
    }
}
