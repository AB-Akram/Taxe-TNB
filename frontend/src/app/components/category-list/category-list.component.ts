import { Component, OnInit } from '@angular/core';
import { Category } from '../../models/categoryModel/category';
import { NgForOf } from '@angular/common';
import { CategoryService } from '../../services/categoryService/category.service';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [NgForOf], //ngModule pour la version précedente
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css',
})
export class CategoryListComponent implements OnInit {
  categories!: Category[];
  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    // pour teste statiquement si les objets passe vers la boucle for sur la partie html
    /*
    this.categories =  [{
      "id" : 1,
      "name" : "Villa",
      "rate" : 50,
      "fields" : []
    }];
    */
   this.getCategories(); //execution de la fonction getCategories
  }

  private getCategories() {
    this.categoryService.getCategoryList().subscribe((data) => {
      this.categories = data;
    });
  }
}
