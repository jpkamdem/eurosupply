import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';

import type { Aliment } from '../types/Aliment';
import type { Medic } from '../types/Medic';
import type { Materiel } from '../types/Materiel';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  #http = inject(HttpClient);

  #products = signal<(Aliment | Medic | Materiel)[]>([]);

  addProduct(product: Aliment | Medic | Materiel) {
    this.#products.update((products) => [...products, product]);
  }
}
