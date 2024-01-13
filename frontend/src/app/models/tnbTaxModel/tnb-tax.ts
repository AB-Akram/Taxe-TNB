import { Field } from '../fieldModel/field';

export class TnbTax {
  id!: number;
  labelle!: string;
  year!: number;
  IsPayed!: boolean;
  total!: number;
  field!: Field;
}
