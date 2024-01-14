import { Component, OnInit } from '@angular/core';
import { Category } from '../../models/categoryModel/category';
import { NgForOf, NgIf } from '@angular/common';
import { CategoryService } from '../../services/categoryService/category.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [NgForOf, FormsModule, NgIf], //ngModule pour la version précedente
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css',
})
export class CategoryListComponent implements OnInit {
  categories!: Category[];
  name!: string;
  rate: number = 0;
  updatePost: boolean = false;
  categoryUpdate!: Category;

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

  getCategoryFormData(data: Category) {
    //clear the inputs
    this.name = '';
    this.rate = 0;
    this.categoryService.saveCategory(data).subscribe();
    this.getCategories();
  }

  getCategoryFromList(categoryId: number) {
    this.categories.forEach((value) => {
      if (value.id == categoryId) {
        this.name = value.name;
        this.rate = value.rate;
        this.categoryUpdate = value;
      }
    });
    this.updatePost = true;
  }

  updateCategoryFromData(data: Category) {
    this.name = '';
    this.rate = 0;
    this.categoryUpdate.name = data.name;
    this.categoryUpdate.rate = data.rate;

    this.categoryService.updateCategory(this.categoryUpdate).subscribe();
    this.updatePost = false;
    this.getCategories();
  }

  deleteCategoryFromList(categoryId: number) {
    this.categoryService.deleteCategory(categoryId).subscribe();
    this.getCategories();
  }
}
