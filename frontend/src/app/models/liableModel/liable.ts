import { Field } from '../fieldModel/field';

export class Liable {
  id!: number;
  lastName!: string;
  firstName!: string;
  password!: string;
  cin!: string;
  fields!: Field[];
}
