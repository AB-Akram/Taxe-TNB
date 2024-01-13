import { NgForOf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TnbTax } from '../../models/tnbTaxModel/tnb-tax';
import { TnbTaxService } from '../../services/tnbTaxService/tnb-tax.service';

@Component({
  selector: 'app-tnb-tax-list',
  standalone: true,
  imports: [NgForOf],
  templateUrl: './tnb-tax-list.component.html',
  styleUrl: './tnb-tax-list.component.css',
})
export class TnbTaxListComponent implements OnInit {
  tnbTaxes!: TnbTax[];

  constructor(private tnbTaxService: TnbTaxService) {}

  ngOnInit(): void {
    this.getTnbTaxes();
  }

  private getTnbTaxes() {
    this.tnbTaxService.getTnbTaxList().subscribe((data) => {
      this.tnbTaxes = data;
    });
  }
}
