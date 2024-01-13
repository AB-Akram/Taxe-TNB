import { Routes } from '@angular/router';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { LiableListComponent } from './components/liable-list/liable-list.component';
import { FieldListComponent } from './components/field-list/field-list.component';
import { TnbTaxListComponent } from './components/tnb-tax-list/tnb-tax-list.component';

export const routes: Routes = [
    {path: 'categories', component: CategoryListComponent},
    {path: 'liables', component: LiableListComponent},
    {path: 'fields', component: FieldListComponent},
    {path: 'taxes', component: TnbTaxListComponent}
];
