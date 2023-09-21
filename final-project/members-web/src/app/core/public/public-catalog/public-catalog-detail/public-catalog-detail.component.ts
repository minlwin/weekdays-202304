import { DOCUMENT } from '@angular/common';
import { Component, HostListener, Inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-detail',
  templateUrl: './public-catalog-detail.component.html'
})
export class PublicCatalogDetailComponent implements OnInit {

  descriptionData: any
  detailData: any
  reviews: any = [
  {
    rating: 4,
    comment: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Eligendi in eum illo laudantium ab suscipit et aut magni repellat. Hic fugiat consequuntur delectus dolores, sint commodi quod culpa veritatis inventore.',
    commentDate: '2021-1-17',
    reviewer: 'John Smith'
  },
  {
    rating: 7,
    comment: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Eligendi in eum illo laudantium ab suscipit et aut magni repellat. Hic fugiat consequuntur delectus dolores, sint commodi quod culpa veritatis inventore.',
    commentDate: '2020-10-20',
    reviewer: 'Emma Wattson'
  },
  {
    rating: 6,
    comment: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Eligendi in eum illo laudantium ab suscipit et aut magni repellat. Hic fugiat consequuntur delectus dolores, sint commodi quod culpa veritatis inventore.',
    commentDate: '2023-6-29',
    reviewer: 'Tom Hank'
  }]

  quantity = 1
  images = [
    "https://images.unsplash.com/photo-1565034582189-195bb0084dcf?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
    "https://images.unsplash.com/photo-1622398925373-3f91b1e275f5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1474&q=80",
    "https://images.unsplash.com/photo-1567523977592-7959bc5df51e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1402&q=80"
  ]

  constructor(@Inject(DOCUMENT) private document: Document) {}

  ngOnInit(): void {
    this.addClass('catalogDetailContent', 'd-none')
    this.addClass('catalogDescriptionContent', 'd-none')
  }

  plus() {
    this.quantity ++
  }

  minus() {
    if(this.quantity > 1)
      this.quantity --
  }

  selectDescription(event: any) {
    event.target.classList.add('active')
    this.removeClass('catalogDetailTab', 'active')
    this.removeClass('catalogReviewTab', 'active')

    this.removeClass('catalogDescriptionContent', 'd-none')
    this.addClass('catalogDetailContent', 'd-none')
    this.addClass('catalogReviewContent', 'd-none')
  }

  selectDetail(event: any) {
    event.target.classList.add('active')
    this.removeClass('catalogDescriptionTab', 'active')
    this.removeClass('catalogReviewTab', 'active')

    this.removeClass('catalogDetailContent', 'd-none')
    this.addClass('catalogDescriptionContent', 'd-none')
    this.addClass('catalogReviewContent', 'd-none')
  }

  selectReview(event: any) {
    event.target.classList.add('active')
    this.removeClass('catalogDescriptionTab', 'active')
    this.removeClass('catalogDetailTab', 'active')

    this.removeClass('catalogReviewContent', 'd-none')
    this.addClass('catalogDetailContent', 'd-none')
    this.addClass('catalogDescriptionContent', 'd-none')
  }

  private addClass(id: string, name: string) {
    this.document.getElementById(id)?.classList.add(name)
  }

  private removeClass(id: string, name: string) {
    this.document.getElementById(id)?.classList.remove(name)
  }
}
