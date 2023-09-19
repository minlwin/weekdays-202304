import { Component } from '@angular/core';

@Component({
  selector: 'app-catalog-detail',
  templateUrl: './catalog-detail.component.html'
})
export class CatalogDetailComponent {

  images = [
    "https://images.unsplash.com/photo-1565034582189-195bb0084dcf?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
    "https://images.unsplash.com/photo-1622398925373-3f91b1e275f5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1474&q=80",
    "https://images.unsplash.com/photo-1567523977592-7959bc5df51e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1402&q=80"
  ]

  activeCarousel: string = this.images[0]

  changeImage(data: any) {
    console.log(data)
  }

}
