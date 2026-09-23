import { Component, inject, input } from '@angular/core';
import { Unit } from '../../types/Unit';
import { DatePipe } from '@angular/common';
import { AlimentService } from '../../services/aliment-service';

@Component({
  selector: 'app-aliment-item',
  imports: [DatePipe],
  templateUrl: './aliment-item.html',
  styleUrl: './aliment-item.css',
})
export class AlimentItem {
  id = input.required<string>();
  name = input.required<string>();
  quantity = input.required<number>();
  unit = input.required<Unit>();
  expiration = input.required<Date>();

  alimentService = inject(AlimentService);
}
