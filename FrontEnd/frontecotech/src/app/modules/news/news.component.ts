import { Component, OnInit } from '@angular/core';
import { Noticia } from 'src/app/models/noticia';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service.service';
import { Pais } from 'src/app/models/pais';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  noticias: Array<Noticia>;
  negocios: Array<Noticia>;
  divercion: Array<Noticia>;
  paises: Array<Pais>;
  categoria = 'science';
  pais = 'co';
  constructor(private service: ServiceService) { }

  ngOnInit() {

    this.service.getNews('co', 'business').subscribe(res => {
      this.negocios = res.articles;
      console.log(this.noticias);
    });
    this.service.getNews('co', 'health').subscribe(res => {
      this.divercion = res.articles;
      console.log(this.noticias);
    });
    this.service.getNews(this.pais, this.categoria).subscribe(res => {
      this.noticias = res.articles;
      console.log(this.noticias);
    });
    this.service.getCountries().subscribe(res => {
      this.paises = res;
      console.log('_----------------------');
      console.log(this.paises);

    });
  }

  cambiaSeccion() {
    this.service.getNews(this.pais, this.categoria).subscribe(res => {
      this.noticias = res.articles;
      console.log(this.noticias);
    });
  }
  cambiaSecciones() {
    this.service.getNews(this.pais, 'business').subscribe(res => {
      this.negocios = res.articles;
      console.log(this.noticias);
    });
    this.service.getNews(this.pais, 'health').subscribe(res => {
      this.divercion = res.articles;
      console.log(this.noticias);
    });
    this.service.getNews(this.pais, this.categoria).subscribe(res => {
      this.noticias = res.articles;
      console.log(this.noticias);
    });
  }

  private searchCategory(event: any) {
    console.log(event.target.value);
    this.categoria = event.target.value;
    this.cambiaSeccion();
  }
  private searchCountry(event: any) {
    console.log(event.target.value);
    this.pais = event.target.value;
    this.cambiaSecciones();
  }

}
