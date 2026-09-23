import { DatePipe } from '@angular/common';
import { Component, inject, input } from '@angular/core';
import { CartService } from '../../services/cart-service';
import { Unit } from '../../types/Product';

@Component({
  selector: 'app-aliment-item',
  imports: [DatePipe],
  templateUrl: './aliment-item.html',
  styleUrl: './aliment-item.css',
})
export class AlimentItem {
  cartService = inject(CartService);

  id = input.required<string>();
  name = input.required<string>();
  quantity = input.required<number>();
  unit = input.required<Unit>();
  expiration = input.required<Date>();
}
