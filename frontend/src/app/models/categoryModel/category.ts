import { Field } from '../fieldModel/field';

export class Category {
  id!: number;
  name!: string;
  rate!: number;
  fields!: Field[];
}
