import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import type { Aliment } from '../types/Aliment';
import { toSignal } from '@angular/core/rxjs-interop';

@Injectable({
  providedIn: 'root',
})
export class AlimentService {
  #http = inject(HttpClient);

  #aliments = toSignal(
    this.#http.get<Aliment[] | undefined>('http://127.0.0.1:3000/api/food/'),
    { initialValue: [] },
  );

  getAliments() {
    return this.#aliments;
  }
}
