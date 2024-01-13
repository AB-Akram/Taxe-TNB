import { Component, OnInit } from '@angular/core';
import { Field } from '../../models/fieldModel/field';
import { FieldService } from '../../services/fieldService/field.service';
import { NgForOf } from '@angular/common';

@Component({
  selector: 'app-field-list',
  standalone: true,
  imports: [NgForOf],
  templateUrl: './field-list.component.html',
  styleUrl: './field-list.component.css',
})
export class FieldListComponent implements OnInit {
  fields!: Field[];
  constructor(private fieldService: FieldService) {}

  ngOnInit(): void {
    this.getFields();
  }

  private getFields() {
    this.fieldService.getFieldList().subscribe((data) => {
      this.fields = data;
    });
  }
}
