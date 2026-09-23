import { DatePipe } from '@angular/common';
import { Component, inject, input } from '@angular/core';
import { CartService } from '../../services/cart-service';

@Component({
  selector: 'app-medic-item',
  imports: [DatePipe],
  templateUrl: './medic-item.html',
  styleUrl: './medic-item.css',
})
export class MedicItem {
  cartService = inject(CartService);

  id = input.required<string>();
  name = input.required<string>();
  quantity = input.required<number>();
  expiration = input.required<Date>();
}
