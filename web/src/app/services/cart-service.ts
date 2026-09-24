import { Injectable, signal } from '@angular/core';
import { Product } from '../types/Product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  #cart = signal<Product[]>([]);

  readonly cart = this.#cart.asReadonly();

  addToCart(item: Product) {
    this.#cart.update((value: Product[]) => [...this.#cart(), item])
  }


  count() {
    return this.#cart().reduce((count) => count + 1, 0)
  }

  reset() {
    this.#cart.set([]);
  }
}
