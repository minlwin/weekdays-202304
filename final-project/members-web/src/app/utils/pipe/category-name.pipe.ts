import { OnInit, Pipe, PipeTransform } from '@angular/core';
import { EmployeeCategoryService } from '../apis/services/employee/employee-category.service';

@Pipe({
  name: 'categoryName'
})
export class CategoryNamePipe implements PipeTransform, OnInit {

  categories: any[] = []

  constructor(private service: EmployeeCategoryService){}

  ngOnInit(): void {
    this.service.search().subscribe(resp => this.categories = resp)
  }

  transform(value: any): unknown {
    return this.categories.filter(cat => cat.id == value)
               .map(cat => cat.name).pop();
  }

}
