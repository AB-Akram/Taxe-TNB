import { Category } from '../categoryModel/category';
import { Liable } from '../liableModel/liable';
import { TnbTax } from '../tnbTaxModel/tnb-tax';

export class Field {
  id!: number;
  surface!: number;
  address!: string;
  category!: Category;
  tnbTaxes!: TnbTax[];
  liable!: Liable;
}
