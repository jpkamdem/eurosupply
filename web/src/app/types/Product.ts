export type Unit = 'unit' | 'kg' | 'L';

export interface BaseProduct {
  id: string;
  name: string;
  quantity: number;
}

export interface Aliment extends BaseProduct {
  unit: Unit;
  expiration: Date;
}

export interface Medic extends BaseProduct {
  expiration: Date;
}

export interface Materiel extends BaseProduct {}

export type Product = Aliment | Medic | Materiel;