import { Component, OnInit } from '@angular/core';
import { Noticia } from 'src/app/models/noticia';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  noticias: Array<Noticia>;

  constructor(private service:ServiceService) { }

  ngOnInit() {

    this.service.getNews("co","business").subscribe(res=>{
      this.noticias = res.articles;
      console.log(this.noticias)
    });
  }

}
