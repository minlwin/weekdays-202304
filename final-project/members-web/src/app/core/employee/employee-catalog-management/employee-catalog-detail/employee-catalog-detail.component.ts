import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeCatalogService } from 'src/app/utils/apis/services/employee/employee-catalog.service';

@Component({
  selector: 'app-catalog-detail',
  templateUrl: './employee-catalog-detail.component.html'
})
export class EmployeeCatalogDetailComponent implements OnInit {

  images: any[] = []

  activeCarousel: string = this.images[0]
  catalog: any

  constructor(private route: ActivatedRoute,
    private router: Router,
    private empCatalogService: EmployeeCatalogService) {}

  ngOnInit(): void {
    this.route.queryParamMap.subscribe(param => {
      if(param.get('id')) {
        this.empCatalogService.findById(+ (param.get('id') as string)).subscribe(resp => this.setData(resp))
      }
    })
  }

  editCatalog() {
    this.router.navigate(['/employee', 'catalog', 'edit'], {queryParams: {id: this.catalog.id}})
  }

  uploadPhoto(images: FileList) {
    this.empCatalogService.uploadPhotos(this.catalog.id, images).subscribe(resp => this.setData(resp))
  }

  private setData(data: any) {
    this.catalog = data.info
    this.images = data.images
  }
}
