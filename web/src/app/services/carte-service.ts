import { Injectable, Signal, signal } from '@angular/core';
import { Aliment } from '../types/Aliment';

@Injectable({
  providedIn: 'root',
})
export class CarteService {
  #cart = signal<Aliment[]>([]);

  setCart(item: Aliment) {
    this.#cart.update((cart) => [...cart, item]);
  }
}
