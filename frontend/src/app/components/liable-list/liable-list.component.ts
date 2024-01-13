import { Component, OnInit } from '@angular/core';
import { Liable } from '../../models/liableModel/liable';
import { LiableService } from '../../services/liableService/liable.service';
import { NgForOf } from '@angular/common';

@Component({
  selector: 'app-liable-list',
  standalone: true,
  imports: [NgForOf],
  templateUrl: './liable-list.component.html',
  styleUrl: './liable-list.component.css',
})
export class LiableListComponent implements OnInit {
  liables!: Liable[];
  constructor(private liableService: LiableService) {}

  ngOnInit(): void {
    this.getLiables();
  }

  private getLiables() {
    this.liableService.getLiableList().subscribe((data) => {
      this.liables = data;
    });
  }
}
