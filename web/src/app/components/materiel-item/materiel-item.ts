import { Component, inject, input } from '@angular/core';
import { CartService } from '../../services/cart-service';
import { ProductService } from '../../services/product-service';

@Component({
  selector: 'app-materiel-item',
  imports: [],
  templateUrl: './materiel-item.html',
  styleUrl: './materiel-item.css',
})
export class MaterielItem {
  cartService = inject(CartService);
  productService = inject(ProductService);

  id = input.required<string>();
  name = input.required<string>();
  quantity = input.required<number>();
}
